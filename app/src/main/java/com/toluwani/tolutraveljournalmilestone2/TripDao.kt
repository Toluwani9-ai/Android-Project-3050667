package com.toluwani.tolutraveljournalmilestone2

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//This interface defines all the database operations that can be performed on
//the Trip table. Room automatically generates the underlying implementation
//based on these method signatures and annotations.
@Dao
interface TripDao {

    @Query("SELECT * FROM trip_table ORDER BY id DESC")
    fun getAllTrips(): Flow<List<Trip>>
    // Create a new trip into the table.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrip(trip: Trip)
    //Updates an existing trip record.

    @Update
    suspend fun updateTrip(trip: Trip)

    @Delete
    suspend fun deleteTrip(trip: Trip)
}