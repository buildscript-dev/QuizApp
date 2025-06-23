package com.example.quizapp.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun StarPage(navController: NavController) {
    var isLoading by remember { mutableStateOf(true) }

    // Fake loading effect (like fetching data or preparing quiz)
    LaunchedEffect(Unit) {
        delay(3000) // 3 seconds
        isLoading = false
        navController.navigate("home") // Navigate to home or next screen after loading
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(
                color = Color.Black,
                strokeWidth = 4.dp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Loading your quiz...",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray
            )
        }

        // Back button in the top-left corner
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.TopStart)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
}
