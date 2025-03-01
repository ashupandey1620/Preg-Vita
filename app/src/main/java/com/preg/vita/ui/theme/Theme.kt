package com.preg.vita.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF9C4DB9) ,
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFC8ADFC),
    surfaceVariant = Color(0xFFEBB9FE),
    onSurfaceVariant = Color(0xFF3F0A71),
    onSurface = Color(0xFF5F1C9C),
    outline = Color(0xFF6A676E)
)


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF9C4DB9) ,
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFC8ADFC),
    surfaceVariant = Color(0xFFEBB9FE),
    onSurfaceVariant = Color(0xFF3F0A71),
    onSurface = Color(0xFF5F1C9C),
    outline = Color(0xFF6A676E)
)

@Composable
fun PregVitaTheme(
    darkTheme: Boolean = isSystemInDarkTheme() ,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true ,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme ,
        typography = Typography ,
        content = content
    )
}