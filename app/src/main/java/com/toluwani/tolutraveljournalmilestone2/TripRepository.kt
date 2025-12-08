package com.toluwani.tolutraveljournalmilestone2


// This my repository acts as the middle layer between the ViewModel and the Room database.
// This helps keep the architecture organised and makes the code easier to test or extend later.
class TripRepository(private val dao: TripDao) {
    // Live stream of all trips in the database
    val allTrips = dao.getAllTrips()

    //Adds a new trip to the Room database
    suspend fun addTrip(trip: Trip) {
        dao.insertTrip(trip)
    }

    //Updates an existing trip entry
    suspend fun updateTrip(trip: Trip) {
        dao.updateTrip(trip)
    }
    //Deletes a selected from the database
    suspend fun deleteTrip(trip: Trip) {
        dao.deleteTrip(trip)
    }
}