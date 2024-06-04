package com.example.lifechronicles.ui.state

data class EventByIdUIState(
    val description: String = "",
    val img_url: String = "",
    val location: String = "",
    val name: String = "",
    val price: Int = 0,
    val rating: Double = 0.0,
    val loading: Boolean = false,
    val success: Boolean = false,
    val errorMessage: String = "",
)