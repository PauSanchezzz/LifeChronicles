package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.WhiteFilledButton
import com.example.lifechronicles.ui.state.EventByIdUIState
import com.example.lifechronicles.ui.viewModel.EventByIDViewModel
import com.example.lifechronicles.ui.viewModel.EventsListViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    navController: NavController, eventId: String, category: String,
    eventByIDViewModel: EventByIDViewModel = EventByIDViewModel()
) {
    val eventsState by eventByIDViewModel.uiState.collectAsState()
    eventByIDViewModel.initState(category, idEvent = eventId)


    Scaffold(topBar = {
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
    }, content = {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(it)
        ) {
            val (backgroundBox, contentBox, imageBox) = createRefs()
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
            Box(modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 30.dp, topEnd = 30.dp
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
                .background(color = MaterialTheme.colorScheme.onSurface)
                .padding(horizontal = 30.dp, vertical = 20.dp)
                .constrainAs(contentBox) {
                    top.linkTo(imageBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {
                Column(
                    modifier = Modifier.padding(top = 85.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = eventsState.name, style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    Text(
                        text = eventsState.description,
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        WhiteFilledButton(text = eventsState.location,
                            icon = Icons.Default.LocationCity,
                            onClick = { /*TODO*/ }

                        )
                        WhiteFilledButton(text = eventsState.rating.toString(),
                            icon = Icons.Default.Star,
                            onClick = { /*TODO*/ })
                    }
                    WhiteFilledButton(text = eventsState.price.toString(),
                        icon = Icons.Default.MonetizationOn,
                        onClick = { /*TODO*/ })
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    FilledTonalIconButton(modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                        enabled = false,
                        onClick = { /*TODO*/ }) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "shared icon"
                            )
                            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                            Text(text = "share")
                        }
                    }
                }
            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 65.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            imageDetail(img_url = eventsState.img_url)
        }
    })
}

@Composable
fun imageDetail(img_url: String) {
    Box(
        modifier = Modifier
            .size(245.dp)
            .clip(CircleShape)
            .border(8.dp, MaterialTheme.colorScheme.surface, CircleShape),
    ) {
        Image(
            painter = rememberAsyncImagePainter(img_url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
