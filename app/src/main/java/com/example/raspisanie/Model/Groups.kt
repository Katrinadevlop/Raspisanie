package com.example.raspisanie.Model

import com.google.gson.annotations.SerializedName

data class Groups (
    @SerializedName("groupId") val id:Int,
    val groupName: String,
){
    override fun toString(): String {
        return groupName
    }
}