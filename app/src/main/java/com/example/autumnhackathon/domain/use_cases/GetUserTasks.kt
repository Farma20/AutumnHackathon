package com.example.autumnhackathon.domain.use_cases

import com.example.autumnhackathon.data.repositories.UserDataHackathonRepository
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.ui.task.Expeditions
import com.example.autumnhackathon.ui.task.ProductItemDataClass
import com.example.autumnhackathon.utils.Resource
import com.example.autumnhackathon.utils.USER_DATA
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.random.Random

class GetUserTasks @Inject constructor(
    private val userRepository: UserDataHackathonRepository
) {
    operator fun invoke(): Flow<Resource<List<Expeditions>>> = flow {
        try {
            emit(Resource.Loading())
            val response = userRepository.getEvents()

            val data = mutableListOf<Expeditions>()

            response.forEach{expedition ->
                val products = mutableListOf<ProductItemDataClass>()
                expedition.productList.forEach{
                    products.add(ProductItemDataClass(
                        productName = it.productName,
                        productSize = it.productSize,
                    ))
                }

                data.add(
                    Expeditions(
                        number = expedition.number,
                        time = expedition.time?: Random.nextInt(5, 30),
                        status = expedition.status,
                        gateNumber = Random.nextInt(5, 8),
                        productList = products
                    )
                )
            }

            emit(Resource.Success(
                data
            ))
        }catch (e:Exception){
            println(e.message.toString())
            when(e.message.toString()){
                else -> emit(Resource.Error(e.message.toString()))
            }
        }
    }
}