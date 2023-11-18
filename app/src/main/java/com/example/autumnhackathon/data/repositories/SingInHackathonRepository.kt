package com.example.autumnhackathon.data.repositories

import com.example.autumnhackathon.data.source.HackathonApi
import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.SingInResponse
import com.example.autumnhackathon.domain.repositories.SingInRepository
import javax.inject.Inject

class SingInHackathonRepository @Inject constructor(
    private val api: HackathonApi
): SingInRepository {
    override suspend fun singIn(data: SingInDataDataClass): SingInResponse {
        return api.auth(data)
    }

}