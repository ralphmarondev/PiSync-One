package com.ralphmarondev.pisync_one.core.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

class AndroidNotificationService(
    private val context: Context
) : NotificationService {
    override fun showNotification(title: String, message: String) {
        val channelId = "keepsafe_app_channel"
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel =
            NotificationChannel(channelId, "Default", NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(channel)

        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .build()

        manager.notify(1, notification)
    }
}

lateinit var androidNotificationService: NotificationService

actual fun getNotificationService(): NotificationService = androidNotificationService
