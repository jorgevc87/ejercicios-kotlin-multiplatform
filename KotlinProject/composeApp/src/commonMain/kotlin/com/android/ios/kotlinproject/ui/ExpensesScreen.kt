package com.android.ios.kotlinproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.ios.kotlinproject.data.ExpenseManager
import com.android.ios.kotlinproject.data.ExpenseRepoImpl
import com.android.ios.kotlinproject.model.Expense
import com.android.ios.kotlinproject.presentation.ExpensesUiState
import com.android.ios.kotlinproject.presentation.ExpensesViewModel
import com.android.ios.kotlinproject.utils.MDecimalFormatter

val decimalFormatter = MDecimalFormatter("#,###.00")

@Composable
fun ExpensesScreen(
    modifier: Modifier, uiState: ExpensesUiState, onExpenseClick: (expense: Expense) -> Unit
) {

    val viewModel = ExpensesViewModel(repo = ExpenseRepoImpl(ExpenseManager))

    LazyColumn(
        modifier = modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader() {
            Column(modifier = Modifier.fillMaxWidth().background(Color.White)) {
                ExpensesTotalHeader(uiState.total, decimalFormatter)
                AllExpensesHeader()
            }
        }
        items(viewModel.uiState.value.expenses) { expense ->
            ExpensesItem(expense, decimalFormatter) {
                onExpenseClick(expense)
            }
        }
    }


}

@Composable
fun ExpensesTotalHeader(total: Double, decimalFormatter: MDecimalFormatter) {

    Card(
        shape = RoundedCornerShape(30),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.Black)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(130.dp).padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            Text(
                text = "$${decimalFormatter.format(total)}",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "USD",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AllExpensesHeader() {

    Row(
        modifier = Modifier.padding(vertical = 16.dp).background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "All expenses",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Button(
            shape = RoundedCornerShape(50), onClick = {
                // Crear click mas adelante
            }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray, contentColor = Color.Gray
            )
        ) {
            Text("View All")
        }
    }

}

@Composable
fun ExpensesItem(
    expense: Expense,
    decimalFormatter: MDecimalFormatter,
    onExpenseClick: (expense: Expense) -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Card(
        modifier = Modifier.fillMaxWidth().padding(2.dp).clickable {
            onExpenseClick(expense)
        },
        colors = CardDefaults.cardColors(containerColor = colors.background),
        shape = RoundedCornerShape(30)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.primary
            ) {

                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = expense.icon,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Image Icon Expense Item"
                )
            }

            Column(modifier = Modifier.weight(1f).padding(8.dp)) {

                Text(
                    text = expense.category.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = colors.primary
                )

                Text(
                    text = expense.description,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    color = Color.Gray
                )

            }

            Text(
                text = "$${decimalFormatter.format(expense.amount)}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colors.primary
            )
        }
    }
}