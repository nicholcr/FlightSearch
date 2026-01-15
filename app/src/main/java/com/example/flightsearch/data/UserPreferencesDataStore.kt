package com.example.flightsearch.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val INPUT_PREFERENCE_NAME = "input_preferences"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = INPUT_PREFERENCE_NAME
)