package com.ralphmarondev.pisync_one.di

import com.ralphmarondev.pisync_one.core.data.local.preferences.AppPreferences
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

actual val platformModule: Module = module {
    single {
        AppPreferences.create {
            val dir = NSSearchPathForDirectoriesInDomains(
                NSDocumentDirectory, NSUserDomainMask, true
            ).first() as String
            "$dir/${AppPreferences.DATA_STORE_FILE_NAME}"
        }
    }
    single<HttpClientEngine> { Darwin.create() }
}