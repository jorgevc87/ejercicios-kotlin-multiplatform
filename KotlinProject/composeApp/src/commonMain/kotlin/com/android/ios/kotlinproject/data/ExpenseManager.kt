package com.android.ios.kotlinproject.data

import com.android.ios.kotlinproject.model.Expense
import com.android.ios.kotlinproject.model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpensesList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.GROCERIES,
            description = "Weekly buy"
        ),

        Expense(
            id = currentId++,
            amount = 10.2,
            category = ExpenseCategory.SNACKS,
            description = "Homies"
        ),

        Expense(
            id = currentId++,
            amount = 21000.0,
            category = ExpenseCategory.CAR,
            description = "Audi A1"
        ),

        Expense(
            id = currentId++,
            amount = 25.0,
            category = ExpenseCategory.PARTY,
            description = "Weekend party"
        ),

        Expense(
            id = currentId++,
            amount = 25.0,
            category = ExpenseCategory.HOUSE,
            description = "Cleaning"
        ),

        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.OTHER,
            description = "Services"
        )
    )

    fun addNewExpense(expense: Expense) {
        fakeExpensesList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpensesList.indexOfFirst {
            it.id == expense.id
        }

        if (index != -1) {
            fakeExpensesList[index] = fakeExpensesList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun deleteExpense(expense: Expense) {
        val index = fakeExpensesList.indexOfFirst {
            it.id == expense.id
        }

        if (index != -1) fakeExpensesList.remove(expense)
    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.GROCERIES,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.COOFEE,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTHER,
        )
    }
}