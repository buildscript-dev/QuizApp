package com.example.quizapp.Component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.Grey40
import kotlinx.coroutines.delay

@Composable
fun TimerButton(
    startTime: Int = 30,
    onGoHome: () -> Unit,
    onRestartQuiz: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(startTime) }
    var showDialog by remember { mutableStateOf(false) }

    // ⏱ Countdown logic
    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        } else {
            showDialog = true
        }
    }

    // 🧠 AlertDialog when time's up
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { /* Optional: prevent dismiss */ },
            title = { Text("⏰ Time's Up!") },
            text = { Text("Your time has run out. What do you want to do?") },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    onRestartQuiz()
                }) {
                    Text("Restart Quiz")
                }
            },
            dismissButton = {
                Button(onClick = {
                    showDialog = false
                    onGoHome()
                }) {
                    Text("Go Home")
                }
            }
        )
    }

    // ⌛ Timer button
    Button(
        onClick = {},
        enabled = false,
        modifier = Modifier.height(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Grey40,
            contentColor = Color.Gray
        )
    ) {
        Text("Time left: $timeLeft", textAlign = TextAlign.Center)
    }
}
