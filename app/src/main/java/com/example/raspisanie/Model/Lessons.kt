package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Lessons(
    @SerializedName("LesssonID") val id:Int,
    val GroupID: Int,
    val OfficeID: Int,
    val SubjectID:Int,
    val DayID: Int,
    val TeacherID: Int,
    val LessonOrderID:Int,
    val LessonTypesID: Int
)
