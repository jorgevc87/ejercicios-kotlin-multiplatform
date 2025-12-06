package com.android.ios.kotlinproject.domain

import com.android.ios.kotlinproject.model.Expense
import com.android.ios.kotlinproject.model.ExpenseCategory

interface ExpenseRepository {

    fun getAllExpenses(): List<Expense>

    fun addExpense(expense: Expense)

    fun editExpense(expense: Expense)

    fun deleteExpense(expense: Expense)

    fun getCategories(): List<ExpenseCategory>

}