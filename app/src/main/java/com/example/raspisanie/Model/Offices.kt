package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Offices(
    @SerializedName("OfficeID") val id:Int,
    val NumberSeats: String
){
    override fun toString(): String {
        return NumberSeats
    }
}
