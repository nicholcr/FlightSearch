package com.example.flightsearch.data

import kotlinx.coroutines.flow.Flow

interface FlightSearchRepository {

    fun getAllAirportStream(): Flow<List<Airport>>
    fun getAirportStream(): Flow<Airport?>
    fun getAllFavoriteStream(): Flow<List<Favorite>>
    fun getFavoriteStream(): Flow<Favorite?>

    suspend fun insertFavorite(airport: Airport)
    suspend fun deleteFavorite(favorite: Favorite)
}