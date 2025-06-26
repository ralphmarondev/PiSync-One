package com.ralphmarondev.pisync_one

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ralphmarondev.pisync_one.core.theme.LocalThemeState
import com.ralphmarondev.pisync_one.core.theme.PiSyncOneTheme
import com.ralphmarondev.pisync_one.core.theme.ThemeState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    themeState: ThemeState
) {
    CompositionLocalProvider(
        LocalThemeState provides themeState
    ) {
        PiSyncOneTheme(
            darkTheme = themeState.darkMode.collectAsState().value
        ) {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = "PiSync One"
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Outlined.Menu,
                                    contentDescription = "Open navigation bar"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = themeState::toggleTheme) {
                                Icon(
                                    imageVector = Icons.Outlined.LightMode,
                                    contentDescription = "Switch theme"
                                )
                            }
                        },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = MaterialTheme.colorScheme.onPrimary,
                            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hello there, Ralph Maron Eda is here!",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}