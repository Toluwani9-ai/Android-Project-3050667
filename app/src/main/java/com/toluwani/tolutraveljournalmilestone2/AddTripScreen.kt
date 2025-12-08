package com.toluwani.tolutraveljournalmilestone2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

// Allows the user to enter details about a new trip
@Composable
fun AddTripScreen(
    viewModel: TripViewModel,
    navController: NavHostController
) {

    var destination by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    // Main layout of the screen.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Add a New Trip ✈️",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = destination,
            onValueChange = { destination = it },
            label = { Text("Destination") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // A short explanation of the trip.
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Saves the date of the journey.
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // The user additional information.
        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Notes") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (destination.isNotBlank()) {
                    val newTrip = Trip(
                        destination = destination,
                        description = description,
                        date = date,
                        notes = notes
                    )
                    // Send the entered trip to ViewModel so it be saved.
                    viewModel.addTrip(newTrip)
                    // To navigate back to the previous screen.
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Trip")
        }
    }
}