package com.example.lifechronicles.ui.navigation

sealed class AppScreens(val route: String){
    data object  LogInScreen : AppScreens("login_screen")
    data object  SignUpScreen : AppScreens("signup_screen")
    data object  HomeScreen : AppScreens("home_screen")
}
