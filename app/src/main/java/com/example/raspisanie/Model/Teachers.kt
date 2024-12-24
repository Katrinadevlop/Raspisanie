package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Teachers(
    @SerializedName("teacherId") val id:Int,
    val firstName: String,
    val lastName:String,
    val middleName:String,
    val IsAvailable:Boolean,
){
    override fun toString(): String {
        return "$firstName $lastName $middleName"
    }
}