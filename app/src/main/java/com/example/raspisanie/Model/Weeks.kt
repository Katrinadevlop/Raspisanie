package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Weeks(
    @SerializedName("WeeksID") val id:Int,
    val WeekNumber:Int,
    val SemesterID:Int
){
    override fun toString(): String {
        return WeekNumber.toString()
    }
}

