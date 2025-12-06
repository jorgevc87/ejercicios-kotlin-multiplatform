package com.android.ios.kotlinproject.data

import com.android.ios.kotlinproject.domain.ExpenseRepository
import com.android.ios.kotlinproject.model.Expense
import com.android.ios.kotlinproject.model.ExpenseCategory

class ExpenseRepoImpl(private val expenseManager: ExpenseManager) : ExpenseRepository {
    override fun getAllExpenses(): List<Expense> {
        return expenseManager.fakeExpensesList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun deleteExpense(expense: Expense) {
        expenseManager.deleteExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }
}