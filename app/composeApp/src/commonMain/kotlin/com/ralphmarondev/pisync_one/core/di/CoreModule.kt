package com.ralphmarondev.pisync_one.core.di

import com.ralphmarondev.pisync_one.core.data.network.HttpClientFactory
import com.ralphmarondev.pisync_one.core.theme.ThemeState
import com.ralphmarondev.pisync_one.core.theme.ThemeStateImpl
import org.koin.dsl.module

val coreModule = module {
    single<ThemeState> { ThemeStateImpl(get()) }
    single { HttpClientFactory.create(get()) }
}