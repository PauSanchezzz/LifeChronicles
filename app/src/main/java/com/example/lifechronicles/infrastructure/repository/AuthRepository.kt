package com.example.lifechronicles.infrastructure.repository

import android.util.Log
import com.example.lifechronicles.domain.entity.User
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {
    private val _auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _userRepository = UserRepository()
    fun signUp(
        user: User,
        onSuccess: () -> Unit,
    ) {
        _auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _userRepository.createUser(user)
                    onSuccess()
                } else {
                    Log.d("AuthRepository", "Error: ${task.exception?.message}")
                }
            }
    }
}