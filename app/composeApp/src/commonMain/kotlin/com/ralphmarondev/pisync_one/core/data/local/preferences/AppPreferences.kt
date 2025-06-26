package com.ralphmarondev.pisync_one.core.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath

class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme_key")
        private val FIRST_LAUNCH = booleanPreferencesKey("first_launch")

        const val DATA_STORE_FILE_NAME = "prefs.preferences_pb"
        fun create(producePath: () -> String): AppPreferences {
            val dataStore = PreferenceDataStoreFactory.createWithPath(
                produceFile = { producePath().toPath() }
            )
            return AppPreferences(dataStore)
        }
    }

    fun isDarkTheme(): Flow<Boolean> {
        return dataStore.data.map { prefs ->
            prefs[DARK_THEME_KEY] ?: false
        }
    }

    suspend fun setDarkTheme(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[DARK_THEME_KEY] = enabled
        }
    }

    suspend fun setFirstLaunch(value: Boolean) {
        dataStore.edit { prefs ->
            prefs[FIRST_LAUNCH] = value
        }
    }

    fun firstLaunch(): Flow<Boolean> {
        return dataStore.data.map { prefs ->
            prefs[FIRST_LAUNCH] ?: true
        }
    }
}