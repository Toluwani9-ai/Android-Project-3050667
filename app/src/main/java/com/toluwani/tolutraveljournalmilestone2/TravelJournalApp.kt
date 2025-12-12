package com.toluwani.tolutraveljournalmilestone2

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


//Root composable for my entire application.
//This function sets up the navigation and connections

@Composable
fun TravelJournalApp(viewModel: TripViewModel) {

    // Each screen in the app will use this controller to move
    // forwards and backwards between destinations.
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

        // Route for adding a new trip entry.
        // When this screen completes its task, it navigates back to the trip list to shows all updated trip.


        composable("add_trip") {
            AddTripScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}