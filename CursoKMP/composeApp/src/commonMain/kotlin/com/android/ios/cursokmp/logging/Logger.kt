package com.android.ios.cursokmp

interface Logger {
    fun d(tag: String, message: String)
    fun i(tag: String, message: String)
    fun e(tag: String, message: String, throwable: Throwable?)
}

expect fun getLogger(): Logger