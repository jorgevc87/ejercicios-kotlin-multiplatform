package com.android.ios.cursokmp

import android.util.Log

class LoggerAndroid : Logger {

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        Log.e(tag, message)
    }
}

actual fun getLogger(): Logger = LoggerAndroid()