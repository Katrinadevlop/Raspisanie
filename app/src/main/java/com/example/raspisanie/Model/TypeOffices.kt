package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class TypeOffices(
    @SerializedName("TypeOfficesID") val id:Int,
    val OfficeType:String,
){
    override fun toString(): String {
        return OfficeType
    }
}

