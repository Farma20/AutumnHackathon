package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class SingInDataDataClass(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)