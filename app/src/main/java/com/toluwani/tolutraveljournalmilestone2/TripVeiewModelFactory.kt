package com.toluwani.tolutraveljournalmilestone2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TripViewModelFactory(
    private val repository: TripRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TripViewModel::class.java)) {
            return TripViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}