package com.example.worldskillsapp.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldskillsapp.presentation.events.InputUserDataEvents
import com.example.worldskillsapp.presentation.state.UserDataState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InputUserDataViewModel(

): ViewModel() {
    private val _viewState = MutableStateFlow(UserDataState())
    val viewState = _viewState.asStateFlow()

    fun onEvent(event: InputUserDataEvents){
        when (event){
            InputUserDataEvents.CreateOnClick -> createOnClick()
            is InputUserDataEvents.OnBirthdayChange -> onBirthdayChange(event.birthday)
            is InputUserDataEvents.OnMaleChange -> onMaleChange(event.male)
            is InputUserDataEvents.OnNameChange -> onNameChange(event.name)
            is InputUserDataEvents.OnPasswordChange -> onPasswordChange(event.password)
            is InputUserDataEvents.OnPatronymicChange -> onPatronymicChange(event.patronymic)
            is InputUserDataEvents.OnSurnameChange -> onSurnameChange(event.surname)
        }
    }

    private fun createOnClick() {
        viewModelScope.launch {
            //Create user
        }
    }

    private fun onNameChange(name: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(name = name)
            }
        }
    }
    private fun onSurnameChange(surname: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(surname = surname)
            }
        }
    }
    private fun onPatronymicChange(patronymic: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(patronymic = patronymic)
            }
        }
    }
    private fun onBirthdayChange(birthday: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(birthday = birthday)
            }
        }
    }
    private fun onPasswordChange(password: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(password = password)
            }
        }
    }
    private fun onMaleChange(male: String) {
        viewModelScope.launch {
            _viewState.update { state ->
                state.copy(male = male)
            }
        }
    }

}