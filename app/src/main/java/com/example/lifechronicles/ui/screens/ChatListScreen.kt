package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import com.example.lifechronicles.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ChatListScreen(navController: NavHostController = rememberNavController(), onChatClick : () -> Unit){
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.tileConversations),
                    )
                }
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 68.dp)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                for (i in 1..6) {
                    Card( navController, onChatClick)
                }
            }
        }
    )
}

@Composable
fun Card(navController: NavHostController, onClick: () -> Unit){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color(0XFFF1F7ED)),
        elevation = ButtonDefaults.buttonElevation(10.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(horizontal = 25.dp, vertical = 8.dp)
            .border(0.5.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(16.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            CardImage()
            CardText()
        }
    }
}

@Composable
fun CardText() {
    Column(
        modifier = Modifier
            .padding(start = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Titulo",
            fontSize = 28.sp,
            color = MaterialTheme.colorScheme.surface,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "ID: Grupo #001",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            overflow = TextOverflow.Clip,
            modifier = Modifier.padding(vertical = 5.dp),
        )
        ProgressBar()

    }
}

@Composable
fun CardImage() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Image",
        modifier = Modifier
            .padding(end = 15.dp)
            .size(100.dp)
            .clip(CircleShape)
            .border(2.dp, MaterialTheme.colorScheme.surface, CircleShape),
        contentScale = ContentScale.Crop,

        )
}

@Composable
fun ProgressBar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
    ) {
        LinearProgressIndicator(
            progress = 0.8f,
            Modifier
                .height(10.dp)
                .clip(CircleShape)
        )
    }
}





