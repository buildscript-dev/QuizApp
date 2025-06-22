package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.Component.HomePage
import com.example.quizapp.Component.LogIn
import com.example.quizapp.Component.QuizPage

@Composable
fun NavRoute() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        composable("Login") {
            LogIn(navController = navController)
        }
        composable("Home") {
            HomePage(navController = navController)
        }
        composable("QuizStart/{category}") { backStackEntry ->
            QuizPage(navController = navController, backStackEntry = backStackEntry)
        }
    }
}
