package com.ralphmarondev.pisync_one

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform