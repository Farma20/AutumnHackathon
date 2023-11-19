package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class ShiftResponse(
    @SerializedName("detail")
    val detail: String
)