package com.android.ios.kotlinproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.data.ExpenseRepoImpl
import com.android.ios.kotlinproject.data.TitleTopBarTypes
import com.android.ios.kotlinproject.presentation.ExpensesViewModel
import com.android.ios.kotlinproject.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.viewmodel.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    PreComposeApp {

        val viewmodel = viewModel(modelClass = ExpensesViewModel::class) {
            ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
        }

        val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

        val colors = getColors()

        ExpensesTheme {

            val navigator = rememberNavigator()
            val titleTopBar = getTitleTopBar(navigator)

            val isEditOrAddExpenses = titleTopBar != TitleTopBarTypes.DASHBOARD.value

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            if (isEditOrAddExpenses) {
                                IconButton(
                                    onClick = {
                                        navigator.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(start = 16.dp),
                                        imageVector = Icons.Default.ArrowBack,
                                        tint = colors.primary,
                                        contentDescription = "Back Arrow"
                                    )
                                }
                            } else {
                                Icon(
                                    modifier = Modifier.padding(start = 16.dp),
                                    imageVector = Icons.Default.Apps,
                                    tint = colors.primary,
                                    contentDescription = "Dashboard Icon"
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth().background(color = Color.Red),
                        title = {
                            Text(
                                text = titleTopBar,
                                fontSize = 25.sp,
                                color = colors.primary
                            )
                        },
                        actions = {})
                },
                contentColor = Color.Red
            ) { innerPadding ->
                ExpensesScreen(Modifier.padding(innerPadding), uiState = uiState) {
                    navigator.navigate("/addExpenses/${it.id}")
                }
            }
        }
    }
}

@Composable
fun getTitleTopBar(navigator: Navigator): String {
    var titleTopBar = TitleTopBarTypes.DASHBOARD

    val isOnAddExpense =
        navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpenses/{id}")
    if (isOnAddExpense) {
        titleTopBar = TitleTopBarTypes.ADD
    }

    val isEditAddExpense =
        navigator.currentEntry.collectAsState(null).value?.path<Long>("id")

    isEditAddExpense?.let {
        titleTopBar = TitleTopBarTypes.EDIT
    }

    return titleTopBar.value
}