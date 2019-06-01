package com.mak.demomvrx.core.base

import android.app.Application
import com.mak.demomvrx.core.inject.projectModeule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(projectModeule)
        }
    }
}