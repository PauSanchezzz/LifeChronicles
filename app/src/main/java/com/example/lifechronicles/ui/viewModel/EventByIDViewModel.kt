package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.infrastructure.repository.EventRepository
import com.example.lifechronicles.ui.state.EventByIdUIState
import com.example.lifechronicles.ui.state.EventByIdUIState.*
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventByIDViewModel : ViewModel() {

    val _eventRepository = EventRepository()
    private val _state = MutableStateFlow(EventByIdUIState())
    val uiState: StateFlow<EventByIdUIState> = _state.asStateFlow()

    fun initState(category: String, idEvent: String) {
 viewModelScope.launch(Dispatchers.IO) {
             val event = _eventRepository.getEventById(category, idEvent)
             if (event != null) {
                 _state.value = EventByIdUIState(
                     description = event.description,
                     img_url = event.img_url,
                     location = event.location,
                     name = event.name,
                     price = event.price,
                     rating = event.rating,
                     success = true
                 )
             }
         }
    }

}