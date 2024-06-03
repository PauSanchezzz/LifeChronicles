package com.example.lifechronicles.infrastructure.external.repository

import android.util.Log
import com.example.lifechronicles.domain.entity.User
import com.google.firebase.auth.FirebaseAuth

class AuthRepository {
    private val _auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val _userRepository = UserRepository()
    fun currentId(): String {
        return _auth.currentUser?.uid.toString()
    }

    fun LogIn(email: String, password: String, onSuccess: () -> Unit) {
        _auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("AuthRepository", "LogIn ${_auth.currentUser?.uid.toString()}")
                    onSuccess()
                } else {
                    Log.d("AuthRepository", "Error: ${task.exception?.message}")
                }
            }
        Log.d("AuthRepository", "LogIn ${_auth.currentUser?.uid.toString()}")
    }


    fun signUp(user: User, onSuccess: () -> Unit) {
        _auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    user.id = _auth.currentUser?.uid.toString()
                    _userRepository.createUser(user)
                    onSuccess()
                } else {
                    Log.d("AuthRepository", "Error: ${task.exception?.message}")
                }
            }
    }
}