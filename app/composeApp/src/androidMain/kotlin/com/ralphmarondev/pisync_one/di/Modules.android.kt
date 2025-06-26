package com.ralphmarondev.pisync_one.di

import android.content.Context
import com.ralphmarondev.pisync_one.core.data.local.preferences.AppPreferences
import com.ralphmarondev.pisync_one.core.util.AndroidNotificationService
import com.ralphmarondev.pisync_one.core.util.NotificationService
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        AppPreferences.create {
            get<Context>().filesDir.resolve(AppPreferences.DATA_STORE_FILE_NAME).absolutePath
        }
    }
    single<HttpClientEngine> { OkHttp.create() }
    single<NotificationService> { AndroidNotificationService(get()) }
}