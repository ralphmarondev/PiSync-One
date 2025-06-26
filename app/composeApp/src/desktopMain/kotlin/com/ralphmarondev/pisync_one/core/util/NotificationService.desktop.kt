package com.ralphmarondev.pisync_one.core.util

import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon

class DesktopNotificationService : NotificationService {
    override fun showNotification(title: String, message: String) {
        if (!SystemTray.isSupported()) {
            println("System tray not supported on this platform.")
            return
        }

        val tray = SystemTray.getSystemTray()
        val image = Toolkit.getDefaultToolkit().createImage(ByteArray(0))

        val trayIcon = TrayIcon(image, "PiSync One")
        trayIcon.isImageAutoSize = true
        trayIcon.toolTip = "PiSync One Notification"

        try {
            tray.add(trayIcon)
            trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO)
        } catch (e: Exception) {
            println("Notification error: ${e.message}")
        }
    }
}

actual fun getNotificationService(): NotificationService = DesktopNotificationService()