package com.android.ios.kotlinproject.utils

expect class MDecimalFormatter(pattern: String) {
    fun format(number: Double): String
}