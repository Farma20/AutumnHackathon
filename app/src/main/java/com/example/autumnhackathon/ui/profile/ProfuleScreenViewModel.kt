package com.example.autumnhackathon.ui.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autumnhackathon.domain.models.SingInDataDataClass
import com.example.autumnhackathon.domain.models.UserDataDataModel
import com.example.autumnhackathon.domain.use_cases.GetUserDataUserCase
import com.example.autumnhackathon.domain.use_cases.ShiftUseCase
import com.example.autumnhackathon.utils.Resource
import com.example.msmgrouptest.ui.sing_in.SingInScreenViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val getUserDataUserCase: GetUserDataUserCase,
    private val shiftUseCase: ShiftUseCase,
):ViewModel() {

    private var _userData = mutableStateOf<UserDataDataModel?>(null)
    val userData: State<UserDataDataModel?> = _userData

    private val _isLoadingData = mutableStateOf(false)
    val isLoadingData: State<Boolean> = _isLoadingData

    private val _isLoadingShiftData = mutableStateOf(false)
    val isLoadingShiftData: State<Boolean> = _isLoadingShiftData

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            getUserDataUserCase().onEach { result ->
                _isLoadingData.value = false
                when (result) {
                    is Resource.Success -> {
                       _userData.value = result.data
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {
                        _isLoadingData.value = true
                    }
                }
            }.launchIn(this)
        }
    }

    fun startShift(){
        viewModelScope.launch {
            shiftUseCase.startShift().onEach { result ->
                _isLoadingShiftData.value = false
                when (result) {
                    is Resource.Success -> {
                        _userData.value = _userData.value?.copy(activeShift = true)
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {
                        _isLoadingShiftData.value = true
                    }
                }
            }.launchIn(this)
        }
    }

    fun endShift(){
        viewModelScope.launch {
            shiftUseCase.endShift().onEach { result ->
                _isLoadingShiftData.value = false
                when (result) {
                    is Resource.Success -> {
                        _userData.value = _userData.value?.copy(activeShift = false)
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {
                        _isLoadingShiftData.value = true
                    }
                }
            }.launchIn(this)
        }
    }
}