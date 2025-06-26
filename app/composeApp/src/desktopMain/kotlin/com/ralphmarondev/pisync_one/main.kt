package com.ralphmarondev.pisync_one

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ralphmarondev.pisync_one.core.theme.ThemeState
import com.ralphmarondev.pisync_one.di.initKoin
import org.koin.core.context.GlobalContext.get

fun main() {
    initKoin()
    val themeState = get().get<ThemeState>()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "PiSync One",
        ) {
            App(themeState = themeState)
        }
    }
}