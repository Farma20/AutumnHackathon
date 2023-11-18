package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class SingInResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("type")
    val type: String
)