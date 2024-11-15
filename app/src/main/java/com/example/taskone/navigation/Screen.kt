package com.example.taskone.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Recommendation : Screen("recommendation")
    object About : Screen("about")
}
