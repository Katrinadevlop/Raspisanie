package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Semesters(
    @SerializedName("SemesterID") val id:Int,
    val SemesterNumber: String
){
    override fun toString(): String {
        return SemesterNumber
    }
}
