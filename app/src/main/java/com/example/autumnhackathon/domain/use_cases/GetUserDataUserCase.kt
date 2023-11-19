package com.example.autumnhackathon.domain.use_cases

import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.domain.repositories.UserDataRepository
import com.example.autumnhackathon.utils.Resource
import com.example.autumnhackathon.utils.USER_DATA
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUserDataUserCase @Inject constructor(
    private val userRepository: UserDataRepository
){
    operator fun invoke(): Flow<Resource<UserDataDataModel>> = flow {
        try {
            emit(Resource.Loading())
            val response = userRepository.getUserData()
            USER_DATA = response
            emit(Resource.Success(response))
        }catch (e:Exception){
            println(e.message.toString())
            when(e.message.toString()){
                else -> emit(Resource.Error(e.message.toString()))
            }
        }
    }
}