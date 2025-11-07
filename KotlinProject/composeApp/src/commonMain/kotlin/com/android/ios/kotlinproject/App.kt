package com.android.ios.kotlinproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    PreComposeApp {
        val colors = getColorsTheme()

        AppTheme {
            Column(modifier = Modifier.fillMaxSize()) {
                Text("Bienvenidos", color = colors.textColor)
                Text("Curso Kotlin MultiPlatform con Compose")
            }
        }
    }
}