package com.ralphmarondev.pisync_one.core.util

import java.io.File
import java.util.Properties

actual object Secrets {
    private val props = Properties().apply {
        val root = File(System.getProperty("user.dir")).parentFile
        val local = File(root, "local.properties")
        load(local.inputStream().reader())
    }

    actual val BASE_URL = props.getProperty("BASE_URL") ?: error("Missing BASE_URL")
}