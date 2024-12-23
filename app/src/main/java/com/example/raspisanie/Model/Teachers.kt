package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Teachers(
    @SerializedName("TeachersID") val id:Int,
    val FirstName: String,
    val LastName:String,
    val MiddleName:String,
    val IsAvailable:Boolean,
){
    override fun toString(): String {
        return FirstName
    }
}