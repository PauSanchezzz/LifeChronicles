package com.example.lifechronicles.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.EventCard
import com.example.lifechronicles.ui.navigation.graphs.EventsScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsListScreen(navController: NavController, category: String) {
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
            LazyColumn(
                modifier = Modifier.padding(
                    vertical = it.calculateTopPadding() + 10.dp,
                    horizontal = 16.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                items(10) {
                    EventCard(
                        imageUrl = "https://i.redd.it/1f8jhybnge6c1.jpeg",
                        name = category,
                        location = "Location",
                        rating = 5.0,
                        prices = listOf("$10", "$20"),
                        onClick = {
                            navController.navigate("${EventsScreens.EventDetail.route}/${TODO()}")
                        }
                    )
                }
            }

        }
    )
}