package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.lifechronicles.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {
    val scrollState = rememberScrollState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(id = R.string.tileConversations),
            )
        })
    }, content = {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it)
        ) {
            val (backgroundBox, contentBox, headerBox) = createRefs()
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface)
                .constrainAs(backgroundBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(headerBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(contentBox.top)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape)
                        .border(1.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)

                ) {
                    Image(
                        painter = rememberAsyncImagePainter("https://i.pinimg.com/564x/e8/c7/3c/e8c73c79273b67f409f87e42d1a2ec00.jpg"),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 24.dp),
                    text = "Titulo Grupo",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Box(modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 30.dp, topEnd = 30.dp
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(vertical = 20.dp)
                .verticalScroll(scrollState)
                .constrainAs(contentBox) {
                    top.linkTo(headerBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {
                Column {
                    Send()
                    Receive()
                    Receive()
                    Send()
                    ProgressBarChat()
                }
            }
        }
    })
}

@Composable
fun Receive() {
    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.tertiary),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topEnd = 16.dp),
            modifier = Modifier
                .padding(5.dp)
                .border(
                    0.5.dp,
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topEnd = 16.dp)
                ),
        ) {
            Row {
                ImageButton()
                TextButton(color = MaterialTheme.colorScheme.surface)
            }

        }
    }
}

@Composable
fun Send() {

    Column(
        modifier = Modifier
            .padding(start = 55.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface),
            elevation = ButtonDefaults.buttonElevation(10.dp),
            shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 16.dp),
            modifier = Modifier
                .padding(5.dp)
                .border(
                    0.5.dp,
                    MaterialTheme.colorScheme.surface,
                    RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp, topStart = 16.dp)
                ),
        ) {
            Row {
                ImageButton()
                TextButton(color = MaterialTheme.colorScheme.onPrimary)
            }

        }
    }
}

@Composable
fun TextButton(color: Color) {
    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Titulo",
            color = color,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Barrio, Bogotá",
            fontSize = 15.sp,
            color = color,
            fontStyle = FontStyle.Italic,
            overflow = TextOverflow.Clip,
        )
        Row {
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "star",
                    tint = Color.Yellow
                )
            }
        }
        Text(
            text = "Precios: 20.000 - 50.000",
            fontSize = 15.sp,
            color = color,
            overflow = TextOverflow.Clip,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun ImageButton() {
    Image(

        painter = painterResource(id = R.drawable.background),
        contentDescription = "Image",
        modifier = Modifier
            .padding(end = 15.dp)
            .width(85.dp)
            .height(90.dp)
            .clip(RoundedCornerShape(percent = 20)),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,

        )
}

@Composable
fun ProgressBarChat() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
    ) {
        LinearProgressIndicator(
            progress = 0.8f,
            Modifier
                .height(18.dp)
                .clip(CircleShape)
        )
    }
}