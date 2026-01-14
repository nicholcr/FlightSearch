package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {

    @Query("SELECT * from airport WHERE name LIKE '%usrSearch%'" +
            "OR iata_code LIKE '%usrSearch%' ORDER BY passengers DESC")
    fun getMatchingAirports(usrSearch: String): Flow<List<Airport?>>

    @Query("SELECT * from airport WHERE name NOT LIKE '%usrSearch%'" +
            "OR iata_code NOT LIKE '%usrSearch%' ORDER BY passengers DESC")
    fun getConnectingAirports(usrSearch: String): Flow<List<Airport?>>

    @Query("SELECT * FROM airport ORDER BY passengers DESC")
    fun getAllAirports(): Flow<List<Airport>>
}