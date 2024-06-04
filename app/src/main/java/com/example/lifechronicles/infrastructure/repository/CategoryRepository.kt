package com.example.lifechronicles.infrastructure.repository

import com.example.lifechronicles.domain.entity.Category
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class CategoryRepository {

    private val firestore = FirebaseFirestore.getInstance().collection("categories")

    suspend fun getCategory(): List<Category>? {
        val categoryList = mutableListOf<Category>()
        return try {
            val categories = firestore.get().await()
            for (category in categories) {
                val category = category.toObject(Category::class.java)
                categoryList.add(category)
            }
            categoryList.filter { category ->
                category.name?.lowercase() != "recomendado"
            }
        } catch (e: Exception) {
            null
        }
    }

}