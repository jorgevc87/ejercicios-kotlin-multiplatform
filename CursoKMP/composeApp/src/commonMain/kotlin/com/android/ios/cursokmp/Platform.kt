package com.android.ios.cursokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform