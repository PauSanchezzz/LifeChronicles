package com.example.lifechronicles.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RecommendationList(modifier: Modifier, onClick : () -> Unit){
    LazyRow(modifier) {
        items(
            count = 10
        ) {
            RecommendationCard(
                imageUrl = "https://i.redd.it/1f8jhybnge6c1.jpeg",
                placeName = "Place Name",
                location = "Location",
                rating = 4.5,
                onClick = onClick,
            )
        }
    }
}