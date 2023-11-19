package com.example.autumnhackathon.domain.models


import com.google.gson.annotations.SerializedName

data class UserDataDataModel(
    @SerializedName("active_shift")
    val activeShift: Boolean,
    @SerializedName("car_num")
    val carNum: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("expedition")
    val expedition: Any?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("second_name")
    val secondName: String,
    @SerializedName("third_name")
    val thirdName: String,
    @SerializedName("type")
    val type: String
)