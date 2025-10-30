package com.toluwani.traveljournal

import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TravelJournalApp() {
    val navController = rememberNavController()

    // Shared list of destinations between screens
    var destinations by remember { mutableStateOf(listOf<String>()) }

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(
                onStartClick = { navController.navigate("destinations") }
            )
        }

        composable("destinations") {
            DestinationsScreen(onAddClick = {
                navController.navigate("addDestination")
            })
        }

        composable("addDestination") {
            AddDestinationScreen(onSaveClick = { newDestination ->
                destinations = destinations + newDestination
                navController.popBackStack()
            })
        }
    }
}