package com.android.ios.kotlinproject.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.data.ExpenseRepoImpl
import com.android.ios.kotlinproject.getColors
import com.android.ios.kotlinproject.presentation.ExpensesViewModel
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
        initialRoute = "/home",
        build
    )
}

