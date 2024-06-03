package com.example.lifechronicles.domain.entity

class User(
    var id: String = "",
    val name: String = "",
    val lastName: String = "",
    val email: String ="",
    val password: String="",
) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "lastName" to lastName,
            "email" to email,
        )
    }

}