package com.hmwn.cinemakmm.android

import android.app.Application
import com.hmwn.cinemakmm.di.commonModule
import com.hmwn.cinemakmm.di.networkModule
import com.hmwn.cinemakmm.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CinemaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()

    }

    private fun initKoin() {

        startKoin {
            androidContext(this@CinemaApp)
            modules(
                networkModule(true),
                commonModule(),
                repositoryModule()
            )
        }

    }

}