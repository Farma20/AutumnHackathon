package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class ExpeditionItem(
    @SerializedName("gateNumber")
    val gateNumber: Int?,
    @SerializedName("number")
    val number: Int,
    @SerializedName("productList")
    val productList: List<Product>,
    @SerializedName("status")
    val status: Int,
    @SerializedName("time")
    val time: Int?
)