package com.toluwani.tolutraveljournalmilestone2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TripListScreen(
    viewModel: TripViewModel,
    navController: NavHostController
) {
    // Collect trips from ViewModel (StateFlow)
    val trips by viewModel.trips.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_trip") },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Text("+", color = Color.White)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(
                "🌍 Travel Journal",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            if (trips.isEmpty()) {
                Text(
                    "No trips yet. Tap + to add one!",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 20.dp)
                )
            } else {
                LazyColumn {
                    items(trips) { trip ->
                        TripCard(trip)
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}


@Composable
fun TripCard(trip: Trip) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                trip.destination,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(trip.description, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(4.dp))

            Text("📅 ${trip.date}", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(4.dp))

            if (trip.notes.isNotBlank()) {
                Text("📝 ${trip.notes}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}