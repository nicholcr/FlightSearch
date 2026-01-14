package com.example.flightsearch.data

import kotlinx.coroutines.flow.Flow

class OfflineFlightSearchRepository(private val airportDao: AirportDao, private val favoriteDao: FavoriteDao) : FlightSearchRepository {

    override fun getMatchingAirportStream(userSearch: String): Flow<List<Airport?>> = airportDao.getMatchingAirports(userSearch)

    override fun getConnectingFlightStream(name: String): Flow<List<Airport?>> = airportDao.getConnectingAirports(name)

    override fun getAllAirportStream(): Flow<List<Airport>> = airportDao.getAllAirports()

    override fun getAllFavoriteStream(): Flow<List<Favorite>> = favoriteDao.getFavorites()

    override suspend fun insertFavorite(airport: Airport, connectingAirport: Airport) = favoriteDao.insert(airport, connectingAirport)

    override suspend fun deleteFavorite(favorite: Favorite) = favoriteDao.delete(favorite)
}