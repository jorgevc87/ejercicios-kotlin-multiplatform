package com.android.ios.kotlinproject.utils

import platform.Foundation.NSLocale
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter

actual class MDecimalFormatter actual constructor(pattern: String) {

    private val formatter = NSNumberFormatter().apply {
        this.locale = NSLocale("es_PE")
        this.minimumFractionDigits = 2.toULong()
        this.maximumFractionDigits = 2.toULong()
        this.usesGroupingSeparator = true
    }

    actual fun format(number: Double): String {
        val nsNumber = NSNumber(number)
        return formatter.stringFromNumber(nsNumber) ?: number.toString()
    }
}