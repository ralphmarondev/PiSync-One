package com.ralphmarondev.pisync_one.core.util

class DesktopPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = DesktopPlatform()
actual fun isDesktop(): Boolean = true