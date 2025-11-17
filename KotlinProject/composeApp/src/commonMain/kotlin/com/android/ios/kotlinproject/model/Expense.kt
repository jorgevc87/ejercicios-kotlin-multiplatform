package com.android.ios.kotlinproject.model

data class Expense(
    val id: Long = -1,
    val amount: Double,
    val category: ExpenseCategory,
    val description: String
) {
    val icon = category.icon
}

enum class ExpenseCategory() {
    GROCERIES(),
    PARTY(),
    SNACKS()
}


