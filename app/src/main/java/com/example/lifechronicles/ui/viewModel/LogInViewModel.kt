package com.example.lifechronicles.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.lifechronicles.infrastructure.repository.AuthRepository
import com.example.lifechronicles.ui.state.LogInUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LogInViewModel: ViewModel(){
    val authRepository = AuthRepository()
    private val _state = MutableStateFlow(LogInUIState())
    val uiState: StateFlow<LogInUIState> = _state.asStateFlow()

    fun onEmailChange(email: String){
        _state.value = _state.value.copy(email = email)
    }
    fun onPasswordChange(password: String){
        _state.value = _state.value.copy(password = password)
    }
    fun sanitizeLogInData(){
        _state.value = _state.value.copy(
            email = _state.value.email.trim(),
            password = _state.value.password.trim()
        )
    }
    fun onLogIn(onSuccess: () -> Unit){
        _state.value = _state.value.copy(loading = true)
        sanitizeLogInData()
        authRepository.LogIn(_state.value.email, _state.value.password, onSuccess)
        _state.value = _state.value.copy(loading = false, success = true)
    }
}