package com.example.flightsearch.data

import kotlinx.coroutines.flow.Flow

interface FlightSearchRepository {

    fun getMatchingAirportStream(name: String): Flow<List<Airport?>>
    fun getConnectingFlightStream(name: String): Flow<List<Airport?>>
    fun getAllAirportStream(): Flow<List<Airport>>
    fun getAllFavoriteStream(): Flow<List<Favorite>>

    suspend fun insertFavorite(airport: Airport)
    suspend fun deleteFavorite(favorite: Favorite)
}