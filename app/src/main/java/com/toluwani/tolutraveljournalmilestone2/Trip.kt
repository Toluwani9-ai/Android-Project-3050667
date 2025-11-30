package com.toluwani.tolutraveljournalmilestone2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_table")
data class Trip(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val destination: String,
    val description: String,
    val date: String,
    val notes: String
)