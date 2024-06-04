package com.example.lifechronicles.ui.state

import com.example.lifechronicles.domain.entity.Event

sealed class EventsRecommendedUIState {
    data class Success(val events: List<Event>) : EventsRecommendedUIState()
    data class Error(val exception: Throwable) : EventsRecommendedUIState()
}