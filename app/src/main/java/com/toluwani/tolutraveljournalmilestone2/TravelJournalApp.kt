package com.toluwani.tolutraveljournalmilestone2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TravelJournalApp(viewModel: TripViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "trip_list"
    ) {
        composable("trip_list") {
            TripListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("add_trip") {
            AddTripScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}