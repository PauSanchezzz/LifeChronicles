package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.infrastructure.repository.CategoryRepository
import com.example.lifechronicles.ui.state.CategoryUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
    private val _categoryRepository = CategoryRepository()
    private val _uiState = MutableStateFlow(CategoryUIState.Success(emptyList()))
    val uiState: StateFlow<CategoryUIState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = _categoryRepository.getCategory()
            if (categories != null) {
                _uiState.value = _uiState.value.copy(
                    categories
                )
            }
        }
    }
}