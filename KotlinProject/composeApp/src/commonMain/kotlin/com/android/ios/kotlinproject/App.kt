package com.android.ios.kotlinproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.data.ExpenseRepoImpl
import com.android.ios.kotlinproject.presentation.ExpensesViewModel
import com.android.ios.kotlinproject.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    PreComposeApp {
        val viewmodel = viewModel(modelClass = ExpensesViewModel::class) {
            ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
        }

        val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

        ExpensesTheme {
            Scaffold(topBar = {
                TopAppBar(
                    modifier = Modifier.background(Color.Yellow),
                    title = { Text("This my TopBar") },
                    navigationIcon = {},
                    actions = {})
            }) { innerPadding ->
                ExpensesScreen(Modifier.padding(innerPadding), uiState = uiState) {

                }
            }
        }
    }
}