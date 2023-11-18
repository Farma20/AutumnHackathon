package com.example.autumnhackathon.data.source

import retrofit2.http.POST

interface HackathonApi {
    @POST("/auth/login")
    suspend fun auth()
}