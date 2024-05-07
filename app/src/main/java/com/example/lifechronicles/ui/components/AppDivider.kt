package com.example.lifechronicles.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 40.dp),
        color = MaterialTheme.colorScheme.primary,
        thickness = 2.dp
    )
}