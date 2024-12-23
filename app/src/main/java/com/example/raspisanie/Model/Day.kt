package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("DayID") val id: Int,
    val dayName: String,
    val weekID: Int
) {
    override fun toString(): String {
        return dayName
    }
}