package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class TypeAssign(
    @SerializedName("OfficeID") val id:Int,
    val OfficeTypeID:Int,
){
    override fun toString(): String {
        return OfficeTypeID.toString()
    }
}
