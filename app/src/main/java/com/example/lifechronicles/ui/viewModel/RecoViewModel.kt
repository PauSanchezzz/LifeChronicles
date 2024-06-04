package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.infrastructure.repository.EventRepository
import com.example.lifechronicles.ui.state.EventsRecommendedUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecoViewModel : ViewModel() {
    private val _eventRepository = EventRepository()
    private val _uiState = MutableStateFlow(EventsRecommendedUIState.Success(emptyList()))
    val uiState: StateFlow<EventsRecommendedUIState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val events = _eventRepository.getEventsRecommended()
            if (events != null) {
                _uiState.value = _uiState.value.copy(
                    events
                )
            }
        }
    }
}