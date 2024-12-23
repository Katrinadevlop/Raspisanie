package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Subjects(
    @SerializedName("SubjectID") val id:Int,
    val SubjectsNumber: String,
    val HoursPerLecture:Int,
    val HoursPerPractic:Int,
    val HoursPerLaborat:Int,
    val HoursPerConsult:Int,
    val HoursPerExam:Int,
    val Subjectscol: String
){
    override fun toString(): String {
        return SubjectsNumber
    }
}