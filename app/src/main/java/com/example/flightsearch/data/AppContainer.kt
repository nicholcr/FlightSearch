package com.example.flightsearch.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val flightSearchRepository: FlightSearchRepository
    val userPreferencesRepository: UserPreferencesRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    private val flightSearchDatabase = FlightSearchDatabase.getDatabase(context)

    override val flightSearchRepository: FlightSearchRepository by lazy {
        OfflineFlightSearchRepository(
            flightSearchDatabase.airportDao(),
            flightSearchDatabase.favoriteDao()
        )
    }
    override val userPreferencesRepository: UserPreferencesRepository by lazy {
        UserPreferencesRepository(context.dataStore)
    }
}