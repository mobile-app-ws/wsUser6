package com.example.worldskillsapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldskillsapp.presentation.events.SignInEvents
import com.example.worldskillsapp.presentation.state.SignInState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(

): ViewModel() {
    private val _viewState = MutableStateFlow(SignInState())
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            while (viewState.value.timer > 0) {
                _viewState.update { state ->
                    state.copy(timer = viewState.value.timer - 1)
                }
                delay(1000)
            }
        }
    }

    fun onEvent(event: SignInEvents) {
        when (event) {
            is SignInEvents.OnEmailChange -> onEmailChange(event.email)
            is SignInEvents.OnCodeChange -> onCodeChange(event.code)
            is SignInEvents.SendCode -> {
                viewModelScope.launch {
                    _viewState.update { state -> state.copy(isLoading = true) }
                    delay(2000)
                    _viewState.update { state -> state.copy(isLoading = false) }
                    event.onSuccessCallback()
                }
            }
            SignInEvents.SendEmail -> {

            }
            SignInEvents.SendCodeAgain -> {
                _viewState.update { state -> state.copy(timer = 60) }
                viewModelScope.launch {
                    while (viewState.value.timer > 0) {
                        _viewState.update { state ->
                            state.copy(timer = viewState.value.timer - 1)
                        }
                        delay(1000)
                    }
                }
            }
        }
    }

    private fun onEmailChange(email: String){
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(email = email)
            }
        }
    }
    private fun onCodeChange(code: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(code = code)
            }
        }
    }
}