package com.example.lifechronicles.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VoiceChat
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lifechronicles.ui.screens.ChatListScreen
import com.example.lifechronicles.ui.screens.ChatScreen
import com.example.lifechronicles.ui.screens.EventDetailScreen
import com.example.lifechronicles.ui.screens.EventsListScreen
import com.example.lifechronicles.ui.screens.HomeScreen
import com.example.lifechronicles.ui.screens.ProfileScreen


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Chat.route) {
            ChatListScreen(navController = navController, onChatClick = {
                navController.navigate(Graph.CHATS)
            })
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(navController = navController, onSignOut = {
                navController.popBackStack()
                navController.navigate(Graph.AUTHENTICATION)
            })
        }
        eventNavGraph(navController = navController)
        chatNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.chatNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.CHATS, startDestination = ChatScreens.Chat.route
    ) {
        composable(route = ChatScreens.Chat.route) {
            ChatScreen()
        }
    }
}

sealed class ChatScreens(val route: String) {
    data object Chat : ChatScreens(route = "CHAT_SINGLE")
}

fun NavGraphBuilder.eventNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.EVENTS, startDestination = EventsScreens.EventList.route
    ) {
        composable(route = EventsScreens.EventList.route) {
            EventsListScreen(navController, onEventClick = {
                navController.navigate(EventsScreens.EventDetail.route)
            })
        }
        composable(route = EventsScreens.EventDetail.route) {
            EventDetailScreen(navController, onBackClick = {
                navController.popBackStack(
                    route = EventsScreens.EventList.route, inclusive = false
                )
            })
        }
    }
}

sealed class EventsScreens(val route: String) {
    data object EventList : EventsScreens(route = "EVENTS")
    data object EventDetail : EventsScreens(route = "EVENT_DETAIL")
}

sealed class BottomBarScreen(
    val route: String, val title: String, val icon: ImageVector
) {
    data object Home : BottomBarScreen(
        route = "HOME", title = "Home", icon = Icons.Default.Home
    )

    data object Chat : BottomBarScreen(
        route = "CHAT", title = "Chats", icon = Icons.Default.VoiceChat
    )

    data object Profile : BottomBarScreen(
        route = "PROFILE", title = "Profile", icon = Icons.Default.Person
    )
}
