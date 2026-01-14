package com.example.flightsearch.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val flightSearchRepository: FlightSearchRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    val flightSearchDatabase = FlightSearchDatabase.getDatabase(context)

    override val flightSearchRepository: FlightSearchRepository by lazy {
        OfflineFlightSearchRepository(
            flightSearchDatabase.airportDao(),
            flightSearchDatabase.favoriteDao()
        )
    }
}