package com.example.lifechronicles.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lifechronicles.domain.entity.Event


@Composable
fun RecommendationList(modifier: Modifier, recoList: List<Event>, onClick: () -> Unit) {
    LazyRow(modifier) {
        items(recoList) { event ->
            RecommendationCard(
                imageUrl = event.img_url,
                placeName = event.name,
                location = event.location,
                rating = event.rating,
                onClick = onClick,
            )
            Spacer(modifier=Modifier .width(10.dp))
        }
    }
}