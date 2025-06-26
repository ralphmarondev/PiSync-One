package com.ralphmarondev.pisync_one.core.util

import platform.Foundation.NSProcessInfo

actual object Secrets {
    private fun getEnv(key: String): String {
        return NSProcessInfo.processInfo.environment?.get(key)?.toString()
            ?: error("Missing environment variable: $key")
    }

    actual val BASE_URL: String = getEnv("BASE_URL")
}