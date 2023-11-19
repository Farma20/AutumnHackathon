package com.example.autumnhackathon.data.repositories

import com.example.autumnhackathon.data.source.HackathonApi
import com.example.autumnhackathon.domain.models.ExpeditionItem
import com.example.autumnhackathon.domain.models.ShiftResponse
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.domain.repositories.UserDataRepository
import javax.inject.Inject

class UserDataHackathonRepository @Inject constructor(
    private val api: HackathonApi
): UserDataRepository {
    override suspend fun getUserData(): UserDataDataModel {
        return api.getUserData()
    }

    override suspend fun startShift(): ShiftResponse {
        return api.startShift()
    }

    override suspend fun endShift(): ShiftResponse {
        return api.endShift()
    }

    override suspend fun getEvents(): List<ExpeditionItem> {
        return api.getEvents()
    }
}