package com.bytelogs.obvious

import android.app.Application
import com.bytelogs.obvious.injection.AppComponent
import com.bytelogs.obvious.injection.AppModule
import com.bytelogs.obvious.injection.DaggerAppComponent

import com.bytelogs.obvious.injection.NetworkModule


class App : Application() {

    lateinit var injector: AppComponent


    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()


    }

    fun getApplicationComponent(): AppComponent {
        return injector
    }


}