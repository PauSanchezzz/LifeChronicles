package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.infrastructure.repository.EventRepository
import com.example.lifechronicles.ui.state.EventsByCategoryUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventsListViewModel:ViewModel() {
    private val _eventRepository = EventRepository()
    private val _uiState = MutableStateFlow(EventsByCategoryUIState.Success(emptyList()))
    val uiState: StateFlow<EventsByCategoryUIState> = _uiState

    fun initState(categoryName:String){
        viewModelScope.launch(Dispatchers.IO) {
            val events = _eventRepository.getEventsByCategory(categoryName)
            if (events != null) {
                _uiState.value = _uiState.value.copy(
                    events
                )
            }
        }
    }
}