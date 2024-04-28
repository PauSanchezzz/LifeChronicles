package com.example.lifechronicles.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.lifechronicles.R

@Composable
fun EventCard(
    imageUrl: String, name: String, location: String, rating: Double, prices: List<String>
) {
    Card(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier.padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(horizontal = 5.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .weight(0.2F)
            )
            Column(
                modifier = Modifier
                    .weight(0.8F),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                )
                Text(text = location)
                Row {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "star",
                        tint = Color.Yellow
                    )
                }
                Text(text = stringResource(R.string.prices, prices[0], prices[1]))
            }
        }
    }
}