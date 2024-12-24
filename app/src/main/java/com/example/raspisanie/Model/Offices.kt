package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Offices(
    @SerializedName("officeId") val id:Int,
    val numberSeats: Int
){
    override fun toString(): String {
        return id.toString()
    }
}
