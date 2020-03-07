package com.example.koinexample

import android.app.Application
import com.example.koinexample.di.appModule
import org.koin.android.ext.android.startKoin

class KoinApp : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin(listOf(appModule))
    }
}