package com.fedchenko.mafiaassistant

import android.app.Application
import com.fedchenko.mafiaassistant.di.viewModelModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(viewModelModule)
        }
    }
}