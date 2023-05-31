package com.example.worldskillsapp.presentation.events

sealed interface InputUserDataEvents {
    data class OnPasswordChange(val password: String): InputUserDataEvents
    data class OnNameChange(val name: String): InputUserDataEvents
    data class OnSurnameChange(val surname: String): InputUserDataEvents
    data class OnPatronymicChange(val patronymic: String): InputUserDataEvents
    data class OnBirthdayChange(val birthday: String): InputUserDataEvents
    data class OnMaleChange(val male: String): InputUserDataEvents

    object CreateOnClick: InputUserDataEvents
}