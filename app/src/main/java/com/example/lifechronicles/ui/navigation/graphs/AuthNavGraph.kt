package com.example.lifechronicles.ui.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lifechronicles.ui.screens.LogInScreen
import com.example.lifechronicles.ui.screens.SignUpScreen
import com.example.lifechronicles.ui.screens.WelcomeScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Welcome.route
    ) {
        composable (route= AuthScreen.Welcome.route){
            WelcomeScreen(
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                }
            )
        }
        composable(route = AuthScreen.Login.route) {
            LogInScreen(
                // onSuccessfulLogin
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            SignUpScreen(
                // onSuccessfulSignUp
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                },
                onLoginClick = {
                    navController.navigate(AuthScreen.Login.route)
                }
            )
        }

    }
}

sealed class AuthScreen(val route: String) {
    data object Welcome : AuthScreen(route = "WELCOME")
    data object Login : AuthScreen(route = "LOGIN")
    data object SignUp : AuthScreen(route = "SIGN_UP")
}