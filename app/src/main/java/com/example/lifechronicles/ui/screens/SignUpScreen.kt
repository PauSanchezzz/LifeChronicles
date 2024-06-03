package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.CustomTextField
import com.example.lifechronicles.ui.viewModel.SignUpViewModel

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun SignUpScreen(
    onClick: () -> Unit,
    onLoginClick: () -> Unit,
    signUpViewModel: SignUpViewModel = SignUpViewModel()
) {
    val signUpState by signUpViewModel.uiState.collectAsState()
    BoxWithConstraints(
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .drawWithCache {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(alpha = 0.5f), Color.Transparent),
                        startY = size.height / 4,
                        endY = size.height
                    )
                    onDrawWithContent {
                        drawContent()
                        drawRect(gradient, blendMode = BlendMode.Multiply)
                    }
                })
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(15, 15, 0, 0))
                .background(MaterialTheme.colorScheme.onSurface)
                .fillMaxWidth()
                .fillMaxHeight(0.6F),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(bottom = 80.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.lblAccountLogin),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    color = MaterialTheme.colorScheme.surface
                )
                Spacer(modifier = Modifier.width(15.dp))
                OutlinedButton(
                    border = BorderStroke(
                        width = 1.dp, color = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = onLoginClick,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = stringResource(id = R.string.login),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom

    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp, vertical = 175.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    text = stringResource(id = R.string.titleSignUp),
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.surface
                )
                CustomTextField(
                    label = stringResource(id = R.string.name),
                    onValueChange = { signUpViewModel.onNameChange(it) },
                    value = signUpState.name
                )
                CustomTextField(
                    label = stringResource(id = R.string.lastName),
                    onValueChange = { signUpViewModel.onLastNameChange(it) },
                    value = signUpState.lastName
                )
                CustomTextField(
                    label = stringResource(id = R.string.email),
                    onValueChange = { signUpViewModel.onEmailChange(it) },
                    value = signUpState.email
                )
                CustomTextField(
                    label = stringResource(id = R.string.password),
                    onValueChange = { signUpViewModel.onPasswordChange(it) },
                    isHidden = true,
                    value = signUpState.password
                )
                OutlinedButton(
                    modifier = Modifier.padding(12.dp), border = BorderStroke(
                        width = 1.dp, color = MaterialTheme.colorScheme.secondary
                    ), onClick = {
                        signUpViewModel.onSignUp(onClick)
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                    ), enabled = !signUpState.loading
                ) {
                    Text(
                        text = stringResource(id = R.string.signup),
                        fontSize = 22.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 38.dp)
                    )
                }

            }
        }

    }
}


