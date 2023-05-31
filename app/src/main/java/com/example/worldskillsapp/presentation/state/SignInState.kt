package com.example.worldskillsapp.presentation.state

data class SignInState(
    val email: String = "",
    val code: String = "",
    val isLoading: Boolean = false
)
