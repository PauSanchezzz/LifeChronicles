package com.example.lifechronicles.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lifechronicles.ui.screens.EventsListScreen
import com.example.lifechronicles.ui.screens.HomeScreen
import com.example.lifechronicles.ui.screens.LogInScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        composable(route = AppScreens.LogInScreen.route) {
            LogInScreen()
        }
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.EventsListScreen.route) {
            EventsListScreen(navController)
        }
    }
}