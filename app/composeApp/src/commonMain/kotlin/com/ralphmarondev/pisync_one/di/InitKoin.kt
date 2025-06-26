package com.ralphmarondev.pisync_one.di

import com.ralphmarondev.pisync_one.core.di.coreModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            coreModule
        )
    }
}