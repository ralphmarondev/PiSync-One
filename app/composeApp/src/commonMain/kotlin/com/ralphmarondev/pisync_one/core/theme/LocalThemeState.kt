package com.ralphmarondev.pisync_one.core.theme

import androidx.compose.runtime.staticCompositionLocalOf

val LocalThemeState = staticCompositionLocalOf<ThemeState> {
    error("ThemeState is not provided.")
}