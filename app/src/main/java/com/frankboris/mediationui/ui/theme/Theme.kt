package com.frankboris.mediationui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun MediationUITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    secondary: Color = ButtonBlue,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = DeepBlue,
            secondary = secondary,
            background = DeepBlue,
            onPrimary = Color.LightGray,
            onSecondary = Color.White,
            onSurface = Color.White,
        )
    } else {
        lightColors(
            primary = DeepBlue,
            secondary = secondary,
            background = Color.White,
            onPrimary = Color.Gray,
            onSecondary = Color.Black,
            onSurface = Color.DarkGray,
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}