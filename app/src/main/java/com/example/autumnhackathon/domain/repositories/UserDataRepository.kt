package com.example.autumnhackathon.domain.repositories

import com.example.autumnhackathon.domain.models.UserDataDataModel

interface UserDataRepository {
    suspend fun getUserData():UserDataDataModel
}