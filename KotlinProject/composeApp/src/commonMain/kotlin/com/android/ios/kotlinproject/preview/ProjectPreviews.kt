package com.android.ios.kotlinproject.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.ios.kotlinproject.ui.AllExpensesHeader
import com.android.ios.kotlinproject.ui.ExpensesTotalHeader
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun ExpensesTotalHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(194.34)
    }
}

@Composable
@Preview(showBackground = true)
fun AllExpensesHeaderPreviefw() {
    Box(modifier = Modifier.padding(16.dp)) {
        AllExpensesHeader()
    }
}

