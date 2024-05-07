package com.example.lifechronicles.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    onPrimary = Color(0XFFB1DA98),
    primary = Color(0xFF0B6439),
    secondary = Color(0XFF094F29),
    background = Color(0xFFD0E7CF),
    onBackground = Color(0xFF2C9260),
    surface = Color(0xFF094F29),
    onSurface = Color(0xFFFE7F2E2),
    tertiary = Color(0xFF6BCA96),
    onTertiary = Color(0xFF000000),
    error = Color(0xFFCE0D0D),
    onError = Color(0xFFFFFFFF),
   // onPrimary = Color(0xFF184E27)
    /* Other default colors to override
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    */
)

@Composable
fun LifeChroniclesTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}