package com.example.quizapp.Component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.ui.theme.Grey40

@Composable
fun QuizPage(navController: NavController){
    val quizList = quizs.shuffled()
    var currentIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }


    val title: TextStyle = TextStyle(
        fontSize = 38.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )

    Column(modifier = Modifier.fillMaxSize()
        .padding(20.dp)
        .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally) {

        TimerButton(
            startTime = 30,
            onTimeOut = {
                // ⛔ Do something when timer hits 0
                println("Time's up!")
            }
        )

        Spacer(Modifier.height(30.dp))


            Text("Choose the correct answer", style = title, textAlign = TextAlign.Center)


        QuizPallet(
            quizItem = quizList[currentIndex],
            onNextClick = {
                if (currentIndex < quizList.lastIndex) {
                    currentIndex++
                } else {
                    showResult = true // 🏁 All questions done
                }
            }
        )



    }

}


@Composable
fun ResultScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("🎉 Quiz Completed!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Check your score or restart the quiz!", fontSize = 18.sp)
        // Add a restart button if needed
    }
}
