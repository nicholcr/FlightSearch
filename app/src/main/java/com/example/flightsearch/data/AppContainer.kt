package com.example.flightsearch.data

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val offlineFlightSearchRepository: OfflineFlightSearchRepository
}