package com.covidindo

import android.app.Application
import com.covidindo.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger

class Covid19IndonesiaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            logger(logger = PrintLogger())
            androidContext(this@Covid19IndonesiaApplication)
            modules(dataModule)
        }
    }
}
