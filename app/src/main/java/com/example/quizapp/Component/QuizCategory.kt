package com.example.quizapp.Component

fun getQuizListForCategory(category: String): List<Quizs> {
    return when (category) {
         "trend" -> quizsTrending
        "daily" -> quizsDaily
        "math" -> quizsMath
         "history" -> quizsHistory
         "science" -> quizsScience
         "gaming" -> quizsGaming
         "anime" -> quizsAnime
         "sports" -> quizsSports
        else -> emptyList()
    }
}
