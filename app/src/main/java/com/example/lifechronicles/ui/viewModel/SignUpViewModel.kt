package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifechronicles.domain.entity.User
import com.example.lifechronicles.infrastructure.external.repository.AuthRepository
import com.example.lifechronicles.ui.state.SignUpUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    val authRepository = AuthRepository()
    private val _state = MutableStateFlow(SignUpUIState())
    val uiState: StateFlow<SignUpUIState> = _state.asStateFlow()


    fun onNameChange(name: String) {
        _state.value = _state.value.copy(name = name)
    }

    fun onLastNameChange(lastName: String) {
        _state.value = _state.value.copy(lastName = lastName)
    }

    fun onEmailChange(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun sanitizeSignUpData() {
        _state.value = _state.value.copy(
            name = _state.value.name.trim(),
            lastName = _state.value.lastName.trim(),
            email = _state.value.email.trim(),
            password = _state.value.password.trim()
        )
    }

    fun onSignUp(onSuccess: () -> Unit) {
        _state.value = _state.value.copy(loading = true)
        sanitizeSignUpData()
        val user = User(
            name = _state.value.name,
            lastName = _state.value.lastName,
            email = _state.value.email,
            password = _state.value.password,
        )
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.signUp(user, onSuccess)
        }
        _state.value = _state.value.copy(loading = false, success = true)
    }

}