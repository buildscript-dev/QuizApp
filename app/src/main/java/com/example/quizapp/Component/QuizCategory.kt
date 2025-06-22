package com.example.quizapp.Component

fun getQuizListForCategory(category: String): List<Quizs> {
    return when (category) {
        "math" -> quizsMath
        "daily" -> quizsDaily
         "science" -> quizsScience
         "trend" -> quizsTrending
         "anime" -> quizsAnime
         "sport" -> quizsSports
         "gaming" -> quizsGaming
         "history" -> quizsHistory
        else -> emptyList() // default fallback
    }
}
