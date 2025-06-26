package com.ralphmarondev.pisync_one.core.theme

import kotlinx.coroutines.flow.StateFlow

interface ThemeState {
    val darkMode: StateFlow<Boolean>
    fun toggleTheme()
}
