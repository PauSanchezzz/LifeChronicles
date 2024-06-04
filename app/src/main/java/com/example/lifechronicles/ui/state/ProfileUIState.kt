package com.example.lifechronicles.ui.state

data class ProfileUIState(
    val name: String = "",
    val lastName: String = "",
    val email: String = "",
    val loading: Boolean = false,
    val success: Boolean = false,
    val errorMessage: String = "",
)
