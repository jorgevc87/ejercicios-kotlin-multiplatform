package com.android.ios.cursokmp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cursokmp.composeapp.generated.resources.Res
import cursokmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    CustomInit()
}

@Composable
fun Customtext(modifier: Modifier, text: String, fontSize: TextUnit) {
    Text(
        modifier = modifier,
        text = text,
        color = Color.Green,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInit() {

    val isTextClick by remember { mutableStateOf(false) }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Pantalla Principal") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF6200EE),
                        titleContentColor = Color.White
                    )
                )
            }) { innerPadding ->
            Card(
                modifier = Modifier.background(Color.Gray).border(1.dp, Color.Red)
            ) {
                Column(
                    modifier = Modifier.wrapContentSize().background(Color.Yellow)
                        .padding(innerPadding).padding(16.dp)
                ) {
                    Customtext(
                        modifier = Modifier.wrapContentSize().background(Color.Gray),
                        text = "Hola ",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun customPreview() {
    CustomInit()
}

