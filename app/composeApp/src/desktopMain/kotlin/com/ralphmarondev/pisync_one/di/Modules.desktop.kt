package com.ralphmarondev.pisync_one.di

import com.ralphmarondev.pisync_one.core.data.local.preferences.AppPreferences
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual val platformModule: Module = module {
    single {
        AppPreferences.create {
            val userHome = System.getProperty("user.home")
            val prefsDir = File(userHome, ".pisync_one")
            prefsDir.mkdirs()
            File(prefsDir, AppPreferences.DATA_STORE_FILE_NAME).absolutePath
        }
    }
    single<HttpClientEngine> { OkHttp.create() }
}