package com.example.lifechronicles.infrastructure.repository

import android.util.Log
import com.example.lifechronicles.domain.entity.User
import com.google.firebase.firestore.FirebaseFirestore

class UserRepository {
    private val _userCollection = FirebaseFirestore
        .getInstance()
        .collection("users")
    fun createUser(user: User) {
        _userCollection
            .add(user.toMap())
            .addOnSuccessListener {
                Log.d("UserRepository", "User created successfully with id ${it.id}")
            }
            .addOnFailureListener {
                Log.d("UserRepository", "Failure creating user error:${it.message}")
            }
    }
}