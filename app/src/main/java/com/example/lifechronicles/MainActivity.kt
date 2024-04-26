package com.example.lifechronicles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lifechronicles.ui.navigation.AppNavigation
import com.example.lifechronicles.ui.screens.LogInScreen
import com.example.lifechronicles.ui.screens.SignUpScreen
import com.example.lifechronicles.ui.screens.WelcomeScreen
import com.example.lifechronicles.ui.theme.LifeChroniclesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifeChroniclesTheme {
                LogInScreen()
            }
            //AppNavigation()
         // WelcomeScreen()

        }
    }
}