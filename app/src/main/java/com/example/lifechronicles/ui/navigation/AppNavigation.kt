package com.example.lifechronicles.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lifechronicles.ui.screens.ChatListScreen
import com.example.lifechronicles.ui.screens.ChatScreen
import com.example.lifechronicles.ui.screens.EventDetailScreen
import com.example.lifechronicles.ui.screens.EventsListScreen
import com.example.lifechronicles.ui.screens.HomeScreen
import com.example.lifechronicles.ui.screens.LogInScreen
import com.example.lifechronicles.ui.screens.ProfileScreen
import com.example.lifechronicles.ui.screens.WelcomeScreen

@Composable
fun AppNavigation() {
    /*val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.EventDetailScreen.route) {
        composable(route = AppScreens.LogInScreen.route) {
            LogInScreen()
        }
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = AppScreens.EventsListScreen.route) {
            EventsListScreen(navController)
        }
        composable(route = AppScreens.EventDetailScreen.route) {
            EventDetailScreen(navController)
        }
        composable(route = AppScreens.ChatListScreen.route) {
            ChatListScreen()
        }
        composable(route = AppScreens.ChatScreen.route) {
            ChatScreen()
        }
        composable(route = AppScreens.WelcomeScreen.route) {
            WelcomeScreen()
        }
        composable(route = AppScreens.ProfileScreen.route){
            ProfileScreen()
        }
    }*/
}