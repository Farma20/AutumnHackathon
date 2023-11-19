package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("productName")
    val productName: String,
    @SerializedName("productSize")
    val productSize: String
)