package com.example.lifechronicles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lifechronicles.ui.navigation.AppNavigation
import com.example.lifechronicles.ui.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //AppNavigation()
          WelcomeScreen()
        }
    }
}