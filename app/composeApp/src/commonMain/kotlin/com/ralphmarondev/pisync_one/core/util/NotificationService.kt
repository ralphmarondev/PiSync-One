package com.ralphmarondev.pisync_one.core.util

interface NotificationService {
    fun showNotification(title: String, message: String)
}

expect fun getNotificationService(): NotificationService
