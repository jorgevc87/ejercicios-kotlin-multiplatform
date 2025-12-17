package com.android.ios.kotlinproject.utils

import java.text.DecimalFormat

actual class MDecimalFormatter actual constructor(pattern: String) {

    private val formatter = DecimalFormat(pattern)
    actual fun format(number: Double): String {
        val result = formatter.format(number)

        return result
    }


}