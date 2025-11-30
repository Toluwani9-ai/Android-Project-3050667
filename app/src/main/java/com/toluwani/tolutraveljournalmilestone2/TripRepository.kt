package com.toluwani.tolutraveljournalmilestone2

class TripRepository(private val dao: TripDao) {

    val allTrips = dao.getAllTrips()

    suspend fun addTrip(trip: Trip) {
        dao.insertTrip(trip)
    }

    suspend fun updateTrip(trip: Trip) {
        dao.updateTrip(trip)
    }

    suspend fun deleteTrip(trip: Trip) {
        dao.deleteTrip(trip)
    }
}