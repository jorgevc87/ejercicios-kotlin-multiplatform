package com.android.ios.kotlinproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.ios.kotlinproject.presentation.ExpensesUiState
import com.android.ios.kotlinproject.ui.ExpensesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    ExpensesTheme {
        Scaffold(topBar = {
            TopAppBar(
                modifier = Modifier.background(Color.Yellow),
                title = { Text("This my TopBar") },
                navigationIcon = {},
                actions = {})
        }) { innerPadding ->
            ExpensesScreen(Modifier.padding(innerPadding), uiState = ExpensesUiState())
        }
    }
}