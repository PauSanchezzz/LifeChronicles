package com.example.lifechronicles.infrastructure.repository

import android.util.Log
import com.example.lifechronicles.domain.entity.Event
import com.example.lifechronicles.ui.state.EventsUIState
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class EventRepository {
    private val firestore = FirebaseFirestore.getInstance().collection("categories")


    suspend fun getEventsRecommended(): List<Event>? {
                val eventsList = mutableListOf<Event>()
        return try {
            val documento = firestore.document("museo").get().await()
            val events = documento.reference.collection("events").get().await()
            for (event in events) {
                eventsList.add(event.toObject(Event::class.java))
            }
            eventsList
        } catch (e: Exception) {
            null
        }
    }
}