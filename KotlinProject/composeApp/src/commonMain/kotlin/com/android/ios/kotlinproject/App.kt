package com.android.ios.kotlinproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun App() {
    ExpensesTheme {
        Scaffold(topBar = {
            TopAppBar(
                modifier = Modifier.background(Color.Yellow),
                title = { Text("This my TopBar") },
                navigationIcon = {},
                actions = {})
        }) { innerPadding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text("An Item", style = TextStyle.Default)
                    Text("Other Item")
                    Text("Another Item")
                }
            }
        }
    }
}