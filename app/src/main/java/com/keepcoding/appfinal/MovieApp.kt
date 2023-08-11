package com.keepcoding.appfinal

import android.app.Application
import com.keepcoding.appfinal.di.dataModule
import com.keepcoding.appfinal.di.domainModule
import com.keepcoding.appfinal.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.compose.BuildConfig
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MovieApp)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}