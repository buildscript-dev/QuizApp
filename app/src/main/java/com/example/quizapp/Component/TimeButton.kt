package com.example.quizapp.Component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quizapp.ui.theme.Grey40

@Composable
fun TimerButton(
    startTime: Int = 30,
    onTimeOut: () -> Unit = {}
) {
    var timeLeft by remember { mutableStateOf(startTime) }

    // ⏱ Countdown logic
    LaunchedEffect(key1 = timeLeft) {
        if (timeLeft > 0) {
            kotlinx.coroutines.delay(1000L) // wait 1 second
            timeLeft--                     // then decrease time
        } else {
            onTimeOut()                   // trigger timeout action
        }
    }

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
