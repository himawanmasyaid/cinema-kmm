package com.hmwn.cinemakmm.di

import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun commonModule() = module {

    single { createJson() }

}

private fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }
