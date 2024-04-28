package com.example.lifechronicles.ui.screens

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.lifechronicles.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(navController: NavController) {
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
                Text(stringResource(id = R.string.events))
            }
        })
    }, content = {
        BoxWithConstraints(
            Modifier.padding(it),
            contentAlignment = Alignment.BottomEnd,
            propagateMinConstraints = true
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(this.maxHeight.value)
                    .fillMaxWidth(this.maxWidth.value)
                    .background(color = MaterialTheme.colorScheme.surface)
            )
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxWidth()
                    .fillMaxHeight(0.8F)
                    .background(color = MaterialTheme.colorScheme.onSurface)
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Name Event")
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(
                    text = """Description of the event lorem ipsum dolor sit amet, consecteturadipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magnaaliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor inreprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. """
                )
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(text = "Location")
                    Text(text = "Rating")
                    Text(text = "Category")
                }
                Text(text = "Price")
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                FilledTonalIconButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    onClick = { /*TODO*/ })
                {
                    Row(
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "shared icon")
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        Text(text = "share")
                    }
                }

            }
            BoxWithConstraints {
                Image(
                    painter = rememberAsyncImagePainter("https://i.redd.it/1f8jhybnge6c1.jpeg"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(top = 5.dp)
                        .clip(CircleShape)
                        .border(5.dp, MaterialTheme.colorScheme.surface, CircleShape)
                        .fillMaxWidth(this.maxWidth.value)
                        .fillMaxHeight(0.5F)
                )
            }
        }
    })
}

