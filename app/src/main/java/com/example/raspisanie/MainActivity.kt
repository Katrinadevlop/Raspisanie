package com.example.raspisanie

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    internal lateinit var qrScanLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        qrScanLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val scannedData = IntentIntegrator.parseActivityResult(result.resultCode, result.data)?.contents
                if (scannedData != null) {
                    val intent = Intent(this, ButtonViewTable::class.java)
                    startActivity(intent)
                } else {
                    println("Сканирование отменено или не удалось")
                }
            }
        }

        val buttonQR = findViewById<Button>(R.id.button)
        buttonQR.setOnClickListener {
            val integrator = IntentIntegrator(this)
            integrator.setPrompt("Сканируйте QR-код")
            integrator.setBeepEnabled(true)
            integrator.setOrientationLocked(true)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            qrScanLauncher.launch(integrator.createScanIntent())
        }
    }
}
