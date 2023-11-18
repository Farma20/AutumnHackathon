package com.example.autumnhackathon.data.source

import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.SingInResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface HackathonApi {
    @POST("/auth/login")
    suspend fun auth(@Body data: SingInDataDataClass): SingInResponse
}