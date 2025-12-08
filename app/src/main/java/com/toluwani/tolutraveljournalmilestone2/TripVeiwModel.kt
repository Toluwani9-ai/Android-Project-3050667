package com.toluwani.tolutraveljournalmilestone2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

//The ViewModel receives a TripRepository instance through dependency injection,
//allowing the UI to stay completely separate from Room database logic.
class TripViewModel(private val repository: TripRepository) : ViewModel() {

    //A StateFlow containing the full list of trips stored in the database.
    val trips = repository.allTrips.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
    //Adds a new trip to the database.
    fun addTrip(trip: Trip) {
        viewModelScope.launch {
            repository.addTrip(trip)
        }
    }
    //Updates an existing trip.
    fun updateTrip(trip: Trip) {
        viewModelScope.launch {
            repository.updateTrip(trip)
        }
    }
    //Deletes a selected trip from the database.
    fun deleteTrip(trip: Trip) {
        viewModelScope.launch {
            repository.deleteTrip(trip)
        }
    }
}