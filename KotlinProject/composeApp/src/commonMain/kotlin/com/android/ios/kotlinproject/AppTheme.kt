package com.android.ios.kotlinproject

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.android.ios.kotlinproject.utils.AppTypography
import com.android.ios.kotlinproject.utils.md3DarkBackground
import com.android.ios.kotlinproject.utils.md3DarkOnBackground
import com.android.ios.kotlinproject.utils.md3DarkOnPrimary
import com.android.ios.kotlinproject.utils.md3DarkOnPrimaryContainer
import com.android.ios.kotlinproject.utils.md3DarkPrimary
import com.android.ios.kotlinproject.utils.md3DarkPrimaryContainer
import com.android.ios.kotlinproject.utils.md3DarkSurface
import com.android.ios.kotlinproject.utils.md3LightBackground
import com.android.ios.kotlinproject.utils.md3LightOnBackground
import com.android.ios.kotlinproject.utils.md3LightOnPrimary
import com.android.ios.kotlinproject.utils.md3LightOnPrimaryContainer
import com.android.ios.kotlinproject.utils.md3LightPrimary
import com.android.ios.kotlinproject.utils.md3LightPrimaryContainer
import com.android.ios.kotlinproject.utils.md3LightSurface

@Composable
fun ExpensesTheme(
    content: @Composable () -> Unit
) {

    val colors = getColors()

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = Shapes(), // or shared shapes
        content = content
    )
}

@Composable
fun getColors(): ColorScheme {
    val isDark: Boolean = isSystemInDarkTheme()

    return if (isDark) DarkColorScheme else LightColorScheme
}

private val LightColorScheme = lightColorScheme(
    primary = md3LightPrimary,
    onPrimary = md3LightOnPrimary,
    primaryContainer = md3LightPrimaryContainer,
    onPrimaryContainer = md3LightOnPrimaryContainer,
    background = md3LightBackground,
    surface = md3LightSurface,
    onBackground = md3LightOnBackground
)

private val DarkColorScheme = darkColorScheme(
    primary = md3DarkPrimary,
    onPrimary = md3DarkOnPrimary,
    primaryContainer = md3DarkPrimaryContainer,
    onPrimaryContainer = md3DarkOnPrimaryContainer,
    background = md3DarkBackground,
    surface = md3DarkSurface,
    onBackground = md3DarkOnBackground
)