package com.example.msmgrouptest.ui.sing_in

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SingInScreenViewModel @Inject constructor(

): ViewModel() {
    private val _isLoadingData = mutableStateOf(false)
    val isLoadingData: State<Boolean> = _isLoadingData

    private val authEventChannel = Channel<SingInEvent>()
    val authEvents = authEventChannel.receiveAsFlow()


    private var flowJob: Job? = null

    sealed class SingInEvent{
        data class Success(val message:String): SingInEvent()
        data class Error(val message: String) : SingInEvent()
    }
}