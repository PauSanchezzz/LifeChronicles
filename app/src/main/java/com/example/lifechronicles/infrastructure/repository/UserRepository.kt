package com.example.lifechronicles.infrastructure.external.repository

import android.util.Log
import com.example.lifechronicles.domain.entity.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class UserRepository {
    private val _userCollection = FirebaseFirestore
        .getInstance()
        .collection("users")

    fun createUser(user: User) {
        _userCollection
            .document(user.id)
            .set(user.toMap())
            .addOnSuccessListener {
                Log.d("UserRepository", "User created successfully")
            }
            .addOnFailureListener {
                Log.d("UserRepository", "Failure creating user error:${it.message}")
            }
    }

    suspend fun getUserById(id: String): User? {
        return try {
            val document = _userCollection
                .document(id)
                .get()
                .await()
            if (document.exists()) {
                User(
                    id = document.id,
                    name = document["name"].toString(),
                    lastName = document["lastName"].toString(),
                    email = document["email"].toString(),
                    password = document["password"].toString(),
                )
            } else {
                Log.d("UserRepository", "No such document")
                null
            }
        } catch (e: Exception) {
            Log.d("UserRepository", "get failed with ", e)
            null
        }
    }
}