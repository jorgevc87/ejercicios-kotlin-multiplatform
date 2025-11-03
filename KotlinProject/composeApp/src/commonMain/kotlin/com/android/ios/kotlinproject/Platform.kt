package com.android.ios.kotlinproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform