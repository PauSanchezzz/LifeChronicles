package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.AppDivider
import com.example.lifechronicles.ui.components.CategoriesGrid
import com.example.lifechronicles.ui.components.RecommendationList

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.welcomeUser),
                    )
                }
            )
        },
        content = {
            Column(
                Modifier.padding(vertical = it.calculateTopPadding(), horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.homeTitle),
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                CategoriesGrid(modifier = Modifier.weight(3F))
                Text(
                    text = stringResource(id = R.string.recommendations),
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                AppDivider()
                RecommendationList(modifier = Modifier.weight(2F))
            }
        }
    )
}