package com.example.autumnhackathon.domain.use_cases

import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.SingInResponse
import com.example.autumnhackathon.domain.repositories.SingInRepository
import com.example.autumnhackathon.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SingInUseCase @Inject constructor(
    private val initialRepository: SingInRepository
){
    operator fun invoke(singInData: SingInDataDataClass): Flow<Resource<SingInResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = initialRepository.singIn(singInData)
            emit(Resource.Success(response))
        }catch (e:Exception){
            println(e.message.toString())
            when(e.message.toString()){
                "timeout"  -> emit(Resource.Error(message = "Превышено время ожидания сервера. Повторите попытку."))
                "Read timed out" -> emit(Resource.Error(message = "Превышено время ожидания сервера. Повторите попытку."))
                "HTTP 401 Unauthorized" -> emit(Resource.Error("Неверный логин или пароль."))
                else -> emit(Resource.Error(e.message.toString()))
            }
        }
    }
}