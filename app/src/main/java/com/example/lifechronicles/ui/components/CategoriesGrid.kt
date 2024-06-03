package com.example.lifechronicles.ui.components

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.navigation.AppScreens

@Composable
fun CategoriesGrid(modifier: Modifier, navController: NavController, onClick: () -> Unit) {
    Card(
        modifier
            .clip(
                RoundedCornerShape(10.dp)
            )
            .padding(vertical = 15.dp),
        elevation = CardDefaults.cardElevation(5.dp),
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
            LazyHorizontalGrid(rows = GridCells.Fixed(2)) {
                items(count = 6) {
                    CategoryCard(
                        "Category",
                        "https://www.diariodelsur.com.co/wp-content/uploads/2023/11/museo-de-la-ind.jpg",
                        onClick = onClick,
                    )
                }
            }
        }
    }
}