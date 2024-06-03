package com.example.lifechronicles.ui.state

import com.example.lifechronicles.domain.entity.Event

sealed class EventsUIState {
    data class Success(val events: List<Event>) : EventsUIState()
    data class Error(val exception: Throwable) : EventsUIState()
}