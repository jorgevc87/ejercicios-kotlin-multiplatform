package com.android.ios.cursokmp

import platform.Foundation.NSLog

class LoggerIos : Logger {

    override fun d(tag: String, message: String) {
        NSLog("DEBUG: $tag - $message")
    }

    override fun i(tag: String, message: String) {
        NSLog("INFO: $tag - $message")
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        NSLog("ERROR: $tag - $message")
    }
}

actual fun getLogger(): Logger = LoggerIos()