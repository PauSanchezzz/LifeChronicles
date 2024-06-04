package com.example.lifechronicles.infrastructure.repository

import com.example.lifechronicles.domain.entity.Event
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.getField
import kotlinx.coroutines.tasks.await

class EventRepository {
    private val firestore = FirebaseFirestore.getInstance().collection("categories")

    suspend fun getEventsByCategory(category: String): List<Event>? {
        val eventsList = mutableListOf<Event>()
        return try {
            val categoryDocument = firestore.document(category.lowercase()).get().await()
            val events = categoryDocument
                .reference
                .collection("events")
                .get()
                .await()
            for (event in events) {
                eventsList.add(
                    Event(
                        id = event.id,
                        description = event.getField<String>("description").toString(),
                        img_url = event.getField<String>("img_url").toString(),
                        location = event.getField<String>("location").toString(),
                        name = event.getField<String>("name").toString(),
                        price = event.getField<Int>("price").toString().toInt(),
                        rating = event.getField<Double>("rating").toString().toDouble()
                    )
                )
            }
            eventsList
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getEventsRecommended(): List<Event>? {
        val eventsList = mutableListOf<Event>()
        return try {
            val documento = firestore.document("museo").get().await()
            val events = documento.reference.collection("events").get().await()
            for (event in events) {
                eventsList.add(
                    Event(
                        id = event.id,
                        description = event.getField<String>("description").toString(),
                        img_url = event.getField<String>("img_url").toString(),
                        location = event.getField<String>("location").toString(),
                        name = event.getField<String>("name").toString(),
                        price = event.getField<Int>("price").toString().toInt(),
                        rating = event.getField<Double>("rating").toString().toDouble()
                    )
                )
            }
            eventsList
        } catch (e: Exception) {
            null
        }
    }
}