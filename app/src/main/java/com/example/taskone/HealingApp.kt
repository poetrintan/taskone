package com.example.taskone

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.taskone.component.BottomBar
import com.example.taskone.navigation.Screen
import com.example.taskone.Screen.HomeScreen
import com.example.taskone.Screen.RecommendationScreen
import com.example.taskone.Screen.AboutScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HealingApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Healing App")
                }
            )
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route, // pastikan Screen sudah didefinisikan
            modifier = modifier.padding(contentPadding)
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen(navController) // Pastikan HomeScreen menerima navController jika diperlukan
            }
            composable(route = Screen.Recommendation.route) {
                RecommendationScreen()
            }
            composable(route = Screen.About.route) {
                AboutScreen()
            }
        }
    }
}
