package com.android.ios.kotlinproject.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.data.ExpenseRepoImpl
import com.android.ios.kotlinproject.getColors
import com.android.ios.kotlinproject.presentation.ExpensesViewModel
import com.android.ios.kotlinproject.ui.ExpensesScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun Navigation(navigator: Navigator) {

    val colors = getColors()

    val viewmodel = viewModel(modelClass = ExpensesViewModel::class) {
        ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
    }

    NavHost(
        modifier = Modifier.background(colors.background),
        navigator = navigator,
        initialRoute = "/home"
    ) {

        scene(route = "/home") {
            val uiState by viewmodel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(Modifier, uiState) { expense ->
                navigator.navigate("/addExpenses/${expense.id}")
            }
        }

        scene(route = "/addExpenses/{id}") { backStackEntry ->
            val idFromPath = backStackEntry.path

        }
    }
}

