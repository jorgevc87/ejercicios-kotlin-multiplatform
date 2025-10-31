package com.android.ios.cursokmp.logging

import com.android.ios.cursokmp.getLogger

object Log {
    private val logger = getLogger()

    fun d(tag: String, message: String) = logger.d(tag, message)
    fun i(tag: String, message: String) = logger.i(tag, message)
    fun e(tag: String, message: String, throwable: Throwable? = null) =
        logger.e(tag, message, throwable)
}