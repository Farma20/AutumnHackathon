package com.example.autumnhackathon.domain.repositories

import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.SingInResponse

interface SingInRepository {
    suspend fun singIn(data:SingInDataDataClass):SingInResponse
}