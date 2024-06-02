package com.example.lifechronicles.domain.entity

class User(
    val id: String = "",
    val name: String,
    val lastName: String,
    val email: String,
    val password: String,
) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "name" to name,
            "lastName" to lastName,
        )
    }
}