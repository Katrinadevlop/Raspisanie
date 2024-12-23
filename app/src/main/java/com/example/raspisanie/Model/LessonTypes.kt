package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class LessonTypes(
    @SerializedName("LesssonTypesID") val id:Int,
    val LesssonTypes: String
){
    override fun toString(): String {
        return LesssonTypes
    }
}
