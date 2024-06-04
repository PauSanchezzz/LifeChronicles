package com.example.lifechronicles.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lifechronicles.domain.entity.Event
import com.example.lifechronicles.ui.navigation.graphs.EventsScreens
import com.example.lifechronicles.ui.navigation.graphs.Graph


@Composable
fun RecommendationList(
    modifier: Modifier, recoList: List<Event>,
    navController: NavHostController,
) {
    LazyRow(modifier) {
        items(recoList) { event ->
            RecommendationCard(
                imageUrl = event.img_url,
                placeName = event.name,
                location = event.location,
                rating = event.rating,
                onClick = {
                    navController.navigate("${EventsScreens.EventDetail.route}/${event.id}/museo")
                },
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}