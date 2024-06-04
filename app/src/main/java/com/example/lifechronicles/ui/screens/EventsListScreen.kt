package com.example.lifechronicles.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifechronicles.ui.components.EventCard
import com.example.lifechronicles.ui.components.RecommendationList
import com.example.lifechronicles.ui.navigation.graphs.EventsScreens
import com.example.lifechronicles.ui.state.EventsByCategoryUIState
import com.example.lifechronicles.ui.state.EventsRecommendedUIState
import com.example.lifechronicles.ui.viewModel.EventsListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsListScreen(
    navController: NavController,
    category: String,
    eventsListViewModel: EventsListViewModel = EventsListViewModel(),
) {
    val eventsState by eventsListViewModel.uiState.collectAsState()
    eventsListViewModel.initState(category)
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        },
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "arrow back"
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(category)
                }
            })
        },
        content = {
            when (val state = eventsState) {
                is EventsByCategoryUIState.Success -> {
                    LazyColumn(
                        modifier = Modifier.padding(
                            vertical = it.calculateTopPadding() + 10.dp,
                            horizontal = 16.dp
                        ),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                    ) {
                        items(state.events)
                        {
                            EventCard(
                                imageUrl = it.img_url,
                                name = it.name,
                                location = it.location,
                                rating = it.rating,
                                price = it.price,
                                onClick = {
                                    navController.navigate("${EventsScreens.EventDetail.route}/${it.id}")
                                }
                            )
                        }
                    }
                }

                is EventsByCategoryUIState.Error -> {
                    TODO()
                }
            }


        }
    )
}