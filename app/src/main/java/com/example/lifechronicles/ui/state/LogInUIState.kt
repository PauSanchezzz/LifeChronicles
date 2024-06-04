package com.example.lifechronicles.ui.state

data class LogInUIState (
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false,
    val success: Boolean = false,
    val errorMessage: String = "",
)
