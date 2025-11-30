package com.toluwani.tolutraveljournalmilestone2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.toluwani.tolutraveljournalmilestone2.ui.theme.ToluTravelJournalMilestone2Theme

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
        setContent {
            ToluTravelJournalMilestone2Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TravelJournalApp(viewModel = viewModel)
                }
            }
        }
    }
}