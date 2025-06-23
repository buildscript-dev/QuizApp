package com.example.quizapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.Component.HomePage
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.quizapp.Component.LogIn
import com.example.quizapp.Component.ProfilePage
import com.example.quizapp.Component.QuizPage
import com.example.quizapp.Component.StarPage
import com.example.quizapp.Component.UserViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun NavRoute() {
    val navController = rememberNavController()
    val userViewModel: UserViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        composable("Login") {
            LogIn(navController = navController)
        }
//        composable("Home") {
//            HomePage(navController = navController)
//        }
        composable("home") {
            HomePage(navController = navController, userViewModel = userViewModel)}

        composable(
            route = "QuizStart/{category}",
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "daily"
            QuizPage(navController = navController, category = category)
        }
//        composable("Profile"){
//            ProfilePage(navController= navController. userViewModel: UserViewModel)
//        }
        composable("profile") {
            ProfilePage(navController = navController, userViewModel = userViewModel)
        }
        composable("star") {
            StarPage(navController = navController)
        }


    }
}
