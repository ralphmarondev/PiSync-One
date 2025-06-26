package com.ralphmarondev.pisync_one.core.util

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect fun isDesktop(): Boolean