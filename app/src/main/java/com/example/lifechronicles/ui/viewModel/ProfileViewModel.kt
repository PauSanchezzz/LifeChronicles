package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.infrastructure.external.repository.AuthRepository
import com.example.lifechronicles.infrastructure.external.repository.UserRepository
import com.example.lifechronicles.ui.state.ProfileUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    val _userRepository = UserRepository()
    val _authRepository = AuthRepository()
    private val _state = MutableStateFlow(ProfileUIState())
    val uiState: StateFlow<ProfileUIState> = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val user = _userRepository.getUserById(_authRepository.currentId())
            if (user != null) {
                _state.value = _state.value.copy(
                    name = user.name,
                    lastName = user.lastName,
                    email = user.email
                )
            }
        }
    }


}