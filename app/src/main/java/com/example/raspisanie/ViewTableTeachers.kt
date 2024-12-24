package com.example.raspisanie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class ViewTableTeachers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_table_teachers)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            loadData()
        }
    }

    @SuppressLint("SetTextI18n")
    private suspend fun loadData(){
        try{
            val groups = OkHttp().apiService.getGroups()
            val lessons = OkHttp().apiService.getLessons()
            val offices = OkHttp().apiService.getOffices()
            val subjects = OkHttp().apiService.getSubjects()
            val teachers = OkHttp().apiService.getTeachers()

            val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

            for (teacher in teachers) {
                val row = TableRow(this)

                val groupTextView = TextView(this).apply {
                    text = teacher.toString()
                    textSize = 16f
                    setPadding(0, 16, 16, 16)
                    gravity = Gravity.CENTER
                }

                row.addView(groupTextView)

                val scheduleInfo = StringBuilder()
                for (lesson in lessons) {
                    if (lesson.teacherId == teacher.id) {
                        val office = offices.find { it.id == lesson.officeId } ?: "Неизвестная группа"
                        val subject = subjects.find { it.id == lesson.subjectId } ?: "Неизвестный предмет"
                        val group = groups.find { it.id == lesson.groupId } ?: "Неизвестный преподаватель"
                        scheduleInfo.append("$office\n$subject\n$group\n\n")
                    }
                }

                val scheduleTextView = TextView(this).apply {
                    text = scheduleInfo.toString()
                    textSize = 14f
                    setPadding(16, 16, 16, 16)
                    gravity = Gravity.START
                }
                row.addView(scheduleTextView)
                tableLayout.addView(row)
            }
        }
        catch (e:Exception)
        {
            Log.e("Api error", "$e")
        }
    }
}