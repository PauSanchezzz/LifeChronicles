package com.example.lifechronicles.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.lifechronicles.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen() {
    ImageBackground()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.welcome),
            fontSize = 35.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Column(
            modifier = Modifier
                .weight(0.7f),
            verticalArrangement = Arrangement.Bottom
        ) {
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF2C9260))
            )
            {
                Text(text = stringResource(id = R.string.login), fontSize = 22.sp, color = Color(0XFFFB1DA98))
            }
        }
        Row(
            modifier = Modifier
                .weight(0.3f)
                .padding(bottom = 50.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.lblHasAccount),
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(15.dp))
            FilledTonalButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0XFFF2C9260))
            ) {
                Text(text = stringResource(id = R.string.signup), color = Color(0XFFFB1DA98))
            }
        }

    }
}

@Composable
fun ImageBackground() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Background",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier.drawWithCache {
            val gradient = Brush.verticalGradient(
                colors = listOf(Color.Black.copy(alpha = 0.7f), Color(0XFFF788072)),
                startY = size.height / 4,
                endY = size.height
            )
            onDrawWithContent {
                drawContent()
                drawRect(gradient, blendMode = BlendMode.Multiply)
            }
        }
    )
}
