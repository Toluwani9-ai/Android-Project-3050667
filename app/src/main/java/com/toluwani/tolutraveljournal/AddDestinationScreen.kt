package com.toluwani.traveljournal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddDestinationScreen(onSaveClick: (String) -> Unit) {
    var destinationName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add New Destination 🌍",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = destinationName,
            onValueChange = { destinationName = it },
            label = { Text("Destination Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (destinationName.isNotBlank()) {
                    onSaveClick(destinationName)
                }
            }
        ) {
            Text("Save Destination")
        }
    }
}