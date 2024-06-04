package com.example.lifechronicles.ui.state

import com.example.lifechronicles.domain.entity.Category


sealed class CategoryUIState {
    data class Success(val categories: List<Category>) : CategoryUIState()
    data class Error(val exception: Throwable) : CategoryUIState()
}