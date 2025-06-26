package com.ralphmarondev.pisync_one.core.util

class IosNotificationService : NotificationService {
    override fun showNotification(title: String, message: String) {
        println("iOS notification not requested: $title - $message")
    }
}

actual fun getNotificationService(): NotificationService = IosNotificationService()