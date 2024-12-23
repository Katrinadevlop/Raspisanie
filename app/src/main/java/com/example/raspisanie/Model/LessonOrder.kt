package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class LessonOrder(
    @SerializedName("LessonOrderID") val id:Int,
    val LesssonOrder: String
){
    override fun toString(): String {
        return LesssonOrder
    }
}
