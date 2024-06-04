package com.example.lifechronicles.ui.state

import com.example.lifechronicles.domain.entity.Event

sealed class EventsByCategoryUIState {
    data class Success(val events: List<Event>) : EventsByCategoryUIState()
    data class Error(val exception: Throwable) : EventsByCategoryUIState()
}