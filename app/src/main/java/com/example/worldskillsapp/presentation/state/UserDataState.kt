package com.example.worldskillsapp.presentation.state

data class UserDataState(
    val password: String = "",
    val name: String = "",
    val surname: String = "",
    val patronymic: String = "",
    val male: String = "",
    val birthday: String = ""
)
