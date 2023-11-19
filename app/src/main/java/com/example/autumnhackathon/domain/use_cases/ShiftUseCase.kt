package com.example.autumnhackathon.domain.use_cases

import com.example.autumnhackathon.data.repositories.UserDataHackathonRepository
import com.example.autumnhackathon.domain.models.ShiftResponse
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.utils.Resource
import com.example.autumnhackathon.utils.USER_DATA
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShiftUseCase @Inject constructor(
    private val userRepository: UserDataHackathonRepository
) {
    fun startShift(): Flow<Resource<ShiftResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = userRepository.startShift()
            emit(Resource.Success(response))
        }catch (e:Exception){
            println(e.message.toString())
            when(e.message.toString()){
                else -> emit(Resource.Error(e.message.toString()))
            }
        }
    }

    fun endShift(): Flow<Resource<ShiftResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = userRepository.endShift()
            emit(Resource.Success(response))
        }catch (e:Exception){
            println(e.message.toString())
            when(e.message.toString()){
                else -> emit(Resource.Error(e.message.toString()))
            }
        }
    }
}