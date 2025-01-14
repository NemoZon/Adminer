package com.example.adminer

import android.app.Application
import com.example.adminer.di.appModules
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin() {
            modules(appModules)
        }
    }
}