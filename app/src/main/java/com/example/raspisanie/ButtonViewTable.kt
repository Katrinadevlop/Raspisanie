package com.example.raspisanie

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ButtonViewTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_button_view_table)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonStudent = findViewById<Button>(R.id.button3)
        buttonStudent.setOnClickListener{
            val intent = Intent(this, ViewTableStudent::class.java)
            startActivity(intent)
        }

        val buttonTeacher = findViewById<Button>(R.id.button2)
        buttonTeacher.setOnClickListener{
            val intent = Intent(this, ViewTableTeachers::class.java)
            startActivity(intent)
        }

        val buttonCabinets = findViewById<Button>(R.id.button4)
        buttonCabinets.setOnClickListener{
            val intent = Intent(this, ViewTableCabinets::class.java)
            startActivity(intent)
        }
    }
}