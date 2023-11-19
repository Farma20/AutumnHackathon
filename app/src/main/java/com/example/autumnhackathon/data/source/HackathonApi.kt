package com.example.autumnhackathon.data.source

import com.example.autumnhackathon.domain.models.ShiftResponse
import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.SingInResponse
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.utils.USER_TOKEN
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface HackathonApi {
    @POST("/auth/login")
    suspend fun auth(@Body data: SingInDataDataClass): SingInResponse

    @GET("/user/view")
    suspend fun getUserData(@Header("auth") token: String = USER_TOKEN):UserDataDataModel

    @POST("/driver/start_shift")
    suspend fun startShift(@Header("auth") token: String = USER_TOKEN):ShiftResponse

    @POST("/driver/end_shift")
    suspend fun endShift(@Header("auth") token: String = USER_TOKEN):ShiftResponse
}