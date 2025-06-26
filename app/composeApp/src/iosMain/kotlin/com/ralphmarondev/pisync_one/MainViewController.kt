package com.ralphmarondev.pisync_one

import androidx.compose.ui.window.ComposeUIViewController
import com.ralphmarondev.pisync_one.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {

}