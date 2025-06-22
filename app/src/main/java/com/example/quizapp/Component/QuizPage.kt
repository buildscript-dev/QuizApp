package com.example.quizapp.Component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavBackStackEntry

@Composable
fun QuizPage(navController: NavController, backStackEntry: NavBackStackEntry) {
    val category = backStackEntry.arguments?.getString("category") ?: "daily"
    val quizList = remember(category) { getQuizListForCategory(category).shuffled() }

    var currentIndex by remember { mutableStateOf(0) }
    var showResult by remember { mutableStateOf(false) }

    val title: TextStyle = TextStyle(
        fontSize = 38.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimerButton(
            onGoHome = {
                navController.navigate("Home") {
                    popUpTo("QuizStart/$category") { inclusive = true }
                }
            },
            onRestartQuiz = {
                navController.navigate("QuizStart/$category") {
                    popUpTo("QuizStart/$category") { inclusive = true }
                }
            }
        )

        Spacer(Modifier.height(30.dp))

        Text(
            "Choose the correct answer",
            style = title,
            textAlign = TextAlign.Center
        )

        if (!showResult) {
            QuizPallet(
                quizItem = quizList[currentIndex],
                onNextClick = {
                    if (currentIndex < quizList.lastIndex) {
                        currentIndex++
                    } else {
                        showResult = true
                    }
                }
            )
        } else {

Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Text("🎉 Quiz Completed!", fontSize = 28.sp, fontWeight = FontWeight.Bold)}
    Text("Total Correct Answer: ${quizList.size}", fontSize = 28.sp, fontWeight = FontWeight.Bold)}
        }
    }
