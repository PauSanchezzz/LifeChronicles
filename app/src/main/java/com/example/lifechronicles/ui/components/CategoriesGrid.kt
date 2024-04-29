package com.example.lifechronicles.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.navigation.AppScreens

@Composable
fun CategoriesGrid(modifier: Modifier, navController: NavController) {
    Card(
        modifier
            .clip(
                RoundedCornerShape(10.dp)
            )
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.categories),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
            )
            AppDivider()
            LazyHorizontalGrid(rows = GridCells.Fixed(2)) {
                items(
                    count = 6
                ) {
                    CategoryCard(
                        "Category",
                        "https://i.redd.it/1f8jhybnge6c1.jpeg",
                        onClick = {
                            navController.navigate(AppScreens.EventsListScreen.route)
                        }
                    )
                }
            }
        }
    }
}