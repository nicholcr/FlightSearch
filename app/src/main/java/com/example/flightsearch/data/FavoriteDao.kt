package com.example.flightsearch.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(airport: Airport, connectingAirport: Airport)

    @Delete
    suspend fun delete(favorite: Favorite)

    @Query("SELECT * FROM favorite")
    fun getFavorites(): Flow<Favorite>
}