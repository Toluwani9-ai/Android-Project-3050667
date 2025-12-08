package com.toluwani.tolutraveljournalmilestone2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.toluwani.tolutraveljournalmilestone2.ui.theme.ToluTravelJournalMilestone2Theme



// MainActivity is the launch point for my application.
// It purpose is to prepare the ViewModel and load my app
// composable structure that displays all screens in the app.

class MainActivity : ComponentActivity() {

    private val viewModel: TripViewModel by viewModels {
        TripViewModelFactory(
            TripRepository(
                AppDatabase.getDatabase(applicationContext).tripDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Jetpack Compose handles the UI, so setContent() loads the composable, instead of using XML layouts.
        // The theme wraps the whole UI, giving consistent colours and styling.


        setContent {
            ToluTravelJournalMilestone2Theme {
                // Surface provides a background container that adapts to the theme.
                Surface(color = MaterialTheme.colorScheme.background) {

                    // TravelJournalApp() contains the full navigation structure
                    // and receives the ViewModel so all screens can access trip data.
                    TravelJournalApp(viewModel = viewModel)
                }
            }
        }
    }
}