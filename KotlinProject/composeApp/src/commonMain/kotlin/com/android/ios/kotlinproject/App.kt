package com.android.ios.kotlinproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import moe.tlaster.precompose.PreComposeApp

@Composable
@Preview
fun App() {
    PreComposeApp {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("Bienvenidos")
            Text("Curso Kotlin MultiPlatform con Compose")
        }
    }
}