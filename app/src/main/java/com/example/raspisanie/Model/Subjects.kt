package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Subjects(
    @SerializedName("subjectId") val id:Int,
    val subjectName: String,
    val hoursPerLecture:Int,
    val hoursPerPractic:Int,
    val hoursPerLaborat:Int,
    val hoursPerConsult:Int,
    val hoursPerExam:Int,
    val subjectscol: String
){
    override fun toString(): String {
        return subjectName
    }
}