package com.example.worldskillsapp.data.local.preferencesDataStore

@kotlinx.serialization.Serializable
data class Settings(
    val token: String = ""
)