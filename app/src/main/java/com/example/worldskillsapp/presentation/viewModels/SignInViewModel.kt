package com.example.worldskillsapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldskillsapp.presentation.events.SignInEvents
import com.example.worldskillsapp.presentation.state.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(

): ViewModel() {
    private val _viewState = MutableStateFlow(SignInState())
    val viewState = _viewState.asStateFlow()

    fun onEvent(event: SignInEvents) {
        when (event) {
            is SignInEvents.OnEmailChange -> onEmailChange(event.email)
            SignInEvents.SendCode -> {

            }
            SignInEvents.SendEmail -> {

            }
            is SignInEvents.OnCodeChange -> onCodeChange(event.code)
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