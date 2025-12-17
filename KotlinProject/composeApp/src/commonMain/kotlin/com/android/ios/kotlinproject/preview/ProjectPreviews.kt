package com.android.ios.kotlinproject.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.ios.kotlinproject.App
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.model.Expense
import com.android.ios.kotlinproject.model.ExpenseCategory
import com.android.ios.kotlinproject.ui.AllExpensesHeader
import com.android.ios.kotlinproject.ui.ExpensesItem
import com.android.ios.kotlinproject.ui.ExpensesTotalHeader
import com.android.ios.kotlinproject.ui.decimalFormatter
import com.android.ios.kotlinproject.utils.MDecimalFormatter
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun ExpensesTotalHeaderPreview() {

    val decimalFormatter = MDecimalFormatter("#,###.00")

    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(194.34, decimalFormatter)
    }
}

@Composable
@Preview(showBackground = true)
fun AllExpensesHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        AllExpensesHeader()
    }
}

@Composable
@Preview(showBackground = true)
fun ExpensesItemPreview() {
    Box(modifier = Modifier.padding(16.dp).background(Color.Red)) {

        ExpensesItem(ExpenseManager.fakeExpensesList.first(), decimalFormatter) {

        }
    }
}

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    App()
}
