package com.ralphmarondev.pisync_one

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "PiSync One",
    ) {
        App()
    }
}