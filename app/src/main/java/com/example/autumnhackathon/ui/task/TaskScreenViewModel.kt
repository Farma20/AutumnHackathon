package com.example.autumnhackathon.ui.task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autumnhackathon.domain.use_cases.GetUserTasks
import com.example.autumnhackathon.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class TaskScreenViewModel @Inject constructor(
    private val getUserTasks: GetUserTasks
): ViewModel()  {
    private val _expeditions = mutableStateOf<List<Expeditions>?>(null)
    val expeditions: State<List<Expeditions>?> = _expeditions

//    private val _isLoadingData = mutableStateOf(false)
//    val isLoadingData: State<Boolean> = _isLoadingData

    init {
        getTasks()
    }

    private fun getTasks(){
        viewModelScope.launch {
            getUserTasks().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _expeditions.value = result.data!!
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {
                    }
                }
            }.launchIn(this)
        }
    }

}

data class Expeditions(
    val number: Int,
    val time: Int,
    val status: Int,
    val gateNumber: Int,
    val productList: List<ProductItemDataClass>
)

data class ProductItemDataClass(
    val productName:String,
    val productSize:String,
)