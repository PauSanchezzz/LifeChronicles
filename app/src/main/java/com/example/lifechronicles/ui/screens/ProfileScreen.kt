package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.CustomTextField
import java.time.format.TextStyle

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Perfil",
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

            }
            Box(modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 30.dp, topEnd = 30.dp
                    )
                )
                .fillMaxWidth()
                .fillMaxHeight(0.6F)
                .background(color = MaterialTheme.colorScheme.background)
                .padding(vertical = 20.dp)
                .verticalScroll(scrollState)
                .constrainAs(contentBox) {
                    top.linkTo(headerBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {

            }
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom

    ) {
        androidx.compose.material3.Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp, vertical = 165.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 78.dp, bottom = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 5.dp),
                    shape = RoundedCornerShape(30.dp),
                    value = "Nombre",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person2,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.onBackground),
                    onValueChange = { "" },
                    label = {
                        Text(
                            text = "Nombre:",
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 7.dp),
                    shape = RoundedCornerShape(30.dp),
                    value = "Apellido",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person2,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.onBackground),
                    onValueChange = { "" },
                    label = {
                        Text(
                            text = "Apellido:",
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )

                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 7.dp),
                    shape = RoundedCornerShape(30.dp),
                    value = "Correo",

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.onBackground),
                    onValueChange = { "" },
                    label = {
                        Text(
                            text = "Correo:",
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )

                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 7.dp),
                    shape = RoundedCornerShape(30.dp),
                    value = "Contraseña",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Password,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = MaterialTheme.colorScheme.onBackground),
                    onValueChange = { "" },
                    label = {
                        Text(
                            text = "Contraseña:",
                            color = MaterialTheme.colorScheme.surface,
                            fontWeight = FontWeight.Bold
                        )
                    },
                )
                OutlinedButton(
                    modifier = Modifier
                        .padding(12.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
                ) {
                    Text(
                        text = stringResource(id = R.string.signup),
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(horizontal = 38.dp)

                    )
                }

            }
        }

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 95.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(6.dp, MaterialTheme.colorScheme.surface, CircleShape),
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://i.pinimg.com/564x/e8/c7/3c/e8c73c79273b67f409f87e42d1a2ec00.jpg"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }

}