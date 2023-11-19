package com.example.autumnhackathon.domain.repositories

import com.example.autumnhackathon.domain.models.ShiftResponse
import com.example.autumnhackathon.domain.models.UserDataDataModel

interface UserDataRepository {
    suspend fun getUserData():UserDataDataModel

    suspend fun startShift(): ShiftResponse

    suspend fun endShift(): ShiftResponse
}