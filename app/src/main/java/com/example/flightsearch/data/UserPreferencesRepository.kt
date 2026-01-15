package com.example.flightsearch.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferencesRepository(
    private val dataStore: DataStore<Preferences>
) {
    private companion object {
        val USER_INPUT = stringPreferencesKey("user_input")
        const val TAG = "UserPreferencesRepo"
    }

    suspend fun saveUserInput(userInput: String) {
        dataStore.edit { input ->
            input[USER_INPUT] = userInput
        }
    }

    val userInput: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { input ->
            input[USER_INPUT] ?: ""
        }
}