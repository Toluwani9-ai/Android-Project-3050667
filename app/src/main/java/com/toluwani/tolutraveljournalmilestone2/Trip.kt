package com.toluwani.tolutraveljournalmilestone2

import androidx.room.Entity
import androidx.room.PrimaryKey


// My data class represents a single trip entry stored in the Room database.
// Each instance of this class becomes one row inside the "trip_table".
// Manage underlying SQLite table for this app.


@Entity(tableName = "trip_table")
data class Trip(
    //Unique ID for each trip.
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val destination: String,
    val description: String,
    val date: String,
    val notes: String
)