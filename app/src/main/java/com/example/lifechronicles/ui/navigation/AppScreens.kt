package com.example.lifechronicles.ui.navigation

sealed class AppScreens(val route: String) {
    data object LogInScreen : AppScreens("login_screen")
    data object SignUpScreen : AppScreens("signup_screen")
    data object HomeScreen : AppScreens("home_screen")
    data object EventsListScreen : AppScreens("events_list_screen")
    data object EventDetailScreen : AppScreens("event_detail_screen")
    data object ChatListScreen : AppScreens("chat_list_screen")
    data object ChatScreen : AppScreens("chat_screen")
    data object WelcomeScreen : AppScreens("welcome_screen")
}
