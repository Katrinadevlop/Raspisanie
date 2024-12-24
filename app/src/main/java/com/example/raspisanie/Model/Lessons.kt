package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Lessons(
    @SerializedName("LesssonId") val id:Int,
    val groupId: Int,
    val officeId: Int,
    val subjectId:Int,
    val dayId: Int,
    val teacherId: Int,
    val lesssonOrderId:Int,
    val lessonTypesId: Int
)
