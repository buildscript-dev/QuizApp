package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.Component.HomePage
import androidx.navigation.NavType
import androidx.navigation.navArgument
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
        composable(
            route = "QuizStart/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "daily"
            QuizPage(navController = navController, category = category)
        }



    }
}
