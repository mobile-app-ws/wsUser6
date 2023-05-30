package com.example.worldskillsapp

import android.app.Application
import com.example.worldskillsapp.di.api_module
import com.example.worldskillsapp.di.data_module
import com.example.worldskillsapp.di.preferences_module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WorldSkillsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WorldSkillsApp)
            androidLogger()
            modules(
                preferences_module,
                data_module,
                api_module
            )
        }
    }
}