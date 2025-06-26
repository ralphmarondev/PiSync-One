package com.ralphmarondev.pisync_one.core.util

import kotlinx.datetime.Clock

actual fun currentTimeMillis(): Long {
    return Clock.System.now().toEpochMilliseconds()
}