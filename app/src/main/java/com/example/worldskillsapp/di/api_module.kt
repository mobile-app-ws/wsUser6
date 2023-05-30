package com.example.worldskillsapp.di

import com.example.worldskillsapp.data.remote.KtorHttpClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val api_module = module {
    singleOf(::KtorHttpClient)
}