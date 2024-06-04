package com.example.lifechronicles.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.lifechronicles.R
import com.example.lifechronicles.domain.entity.Category
import com.example.lifechronicles.domain.entity.Event
import com.example.lifechronicles.ui.navigation.AppScreens
import com.example.lifechronicles.ui.navigation.graphs.EventsScreens
import com.example.lifechronicles.ui.navigation.graphs.Graph

@Composable
fun CategoriesGrid(
    modifier: Modifier,
    navController: NavHostController,
    categoryList: List<Category>,
) {
    Card(
        modifier
            .clip(
                RoundedCornerShape(10.dp)
            )
            .border(
                0.5.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(10.dp)
            ),
        elevation = CardDefaults.cardElevation(20.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.categories),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold,

                )
            AppDivider()
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.padding(vertical = 6.dp)
            ) {
                items(categoryList) { category ->
                    CategoryCard(
                        category.name,
                        category.img_url,
                        onClick = {
                            navController.navigate("${EventsScreens.EventList.route}/${category.name}")
                        },
                    )
                }
            }
        }
    }
}