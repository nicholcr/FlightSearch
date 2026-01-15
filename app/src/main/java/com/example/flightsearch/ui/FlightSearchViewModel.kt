package com.example.flightsearch.ui

import androidx.lifecycle.ViewModel
import com.example.flightsearch.data.Airport
import com.example.flightsearch.data.Favorite
import com.example.flightsearch.data.FlightSearchRepository
import com.example.flightsearch.data.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlightSearchViewModel(
    private val flightSearchRepository: FlightSearchRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    private val _uiState = MutableStateFlow(FlightSearchUiState())

    fun getMatchingAirports(userSearch: String): Flow<List<Airport?>> = flightSearchRepository.getMatchingAirportStream(userSearch)
    fun getConnectingFlights(userSearch: String): Flow<List<Airport?>> = flightSearchRepository.getConnectingFlightStream(userSearch)
    fun getFavoriteFlights(): Flow<List<Favorite?>> = flightSearchRepository.getAllFavoriteStream()

    suspend fun saveFavorite(departureAirport: Airport, arrivalAirport: Airport) {
        flightSearchRepository.insertFavorite(departureAirport, arrivalAirport)
    }
    suspend fun removeFavorite(id: Int) {
        // TODO: add delete method 
    }
}

// UI state for FlightSearchScreen
data class FlightSearchUiState(val airportList: List<Airport> = listOf())