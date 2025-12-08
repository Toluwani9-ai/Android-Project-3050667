package com.toluwani.tolutraveljournalmilestone2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//A custom ViewModelFactory responsible for creating instances of TripViewModel.
class TripViewModelFactory(
    private val repository: TripRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TripViewModel::class.java)) {

            // Create the ViewModel and pass the repository dependency.
            return TripViewModel(repository) as T
        }
        // If another ViewModel type is requested, it gives an error.
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}