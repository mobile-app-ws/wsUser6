package com.example.worldskillsapp.data.local.preferencesDataStore

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
* Создатель: Павел Рыбаков
* Время создания: May 30, 14:30
* Назначение: хранение данных, которые смогут пережить смерть активити. Проще говоря - жесткий диск
*/
class DataStore(context: Context): IDataStore {
    private val dataStore = context.dataStore
    override suspend fun onBoardInfoIsViewable(value: Boolean) {
        dataStore.updateData { settings ->
            settings.copy(onBoardInfo = value)
        }
    }

    override suspend fun getInfoAboutOnBoard(): Flow<Boolean> = dataStore.data.map { settings ->
        settings.onBoardInfo
    }
}