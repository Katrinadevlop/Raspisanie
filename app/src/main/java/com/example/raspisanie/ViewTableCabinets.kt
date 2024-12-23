package com.example.raspisanie

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
import com.example.raspisanie.Model.Day
import com.example.raspisanie.Model.Groups
import com.example.raspisanie.Model.LessonOrder
import com.example.raspisanie.Model.LessonTypes
import com.example.raspisanie.Model.Lessons
import com.example.raspisanie.Model.Offices
import com.example.raspisanie.Model.Semesters
import com.example.raspisanie.Model.Subjects
import com.example.raspisanie.Model.Teachers
import com.example.raspisanie.Model.TypeOffices
import com.example.raspisanie.Model.Weeks
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ViewTableCabinets : AppCompatActivity() {

    interface ApiService{
        @GET("day/get/")
        suspend fun getDay():List<Day>

        @GET("groups/get/")
        suspend fun getGroups():List<Groups>

        @GET("lessonOrder/get/")
        suspend fun getLessonOrder():List<LessonOrder>

        @GET("lessons/get/")
        suspend fun getLessons():List<Lessons>

        @GET("lessonTypes/get/")
        suspend fun getLessonTypes():List<LessonTypes>

        @GET("offices/get/")
        suspend fun getOffices():List<Offices>

        @GET("semesters/get/")
        suspend fun getSemesters():List<Semesters>

        @GET("subjects/get/")
        suspend fun getSubjects():List<Subjects>

        @GET("teachers/get/")
        suspend fun getTeachers():List<Teachers>

        @GET("typeOffices/get/")
        suspend fun getTypeOffices():List<TypeOffices>

        @GET("weeks/get/")
        suspend fun getWeeks():List<Weeks>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_table)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            loadData()
        }
    }

    private suspend fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.140.17:5016/api/lessons/get/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        try {
            val group = apiService.getGroups()
            val lessons = apiService.getLessons()
            val offices = apiService.getOffices()
            val subjects = apiService.getSubjects()
            val teachers = apiService.getTeachers()

            val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

            for (office in offices) {
                val row = TableRow(this)

                val officeTextView = TextView(this).apply {
                    text = office.NumberSeats
                    textSize = 16f
                    setPadding(16, 16, 16, 16)
                    gravity = Gravity.CENTER
                }

                row.addView(officeTextView)

                val scheduleInfo = StringBuilder()
                for (lesson in lessons) {
                    if (lesson.OfficeID == office.id) {
                        val group = group.find { it.id == lesson.GroupID } ?: "Неизвестная группа"
                        val subject = subjects.find { it.id == lesson.SubjectID } ?: "Неизвестный предмет"
                        val teacher = teachers.find { it.id == lesson.TeacherID } ?: "Неизвестный преподаватель"
                        scheduleInfo.append("$group\n$subject\n$teacher\n\n")
                        var txt = findViewById<TextView>(R.id.textView)
                        txt.text = "$group\n$subject\n$teacher\n\n"
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
        } catch (e: Exception) {
            Log.e("API Error", "Error loading data", e)
        }
    }
}