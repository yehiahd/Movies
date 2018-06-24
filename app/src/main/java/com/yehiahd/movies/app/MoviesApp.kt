package com.yehiahd.movies.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.androidnetworking.AndroidNetworking
import com.yehiahd.movies.di.application.ApplicationComponent
import com.yehiahd.movies.di.application.ApplicationModule
import com.yehiahd.movies.di.application.DaggerApplicationComponent

class MoviesApp : Application() {

    private var mApplicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        getApplicationComponent().inject(moviesApp = this)
        super.onCreate()
        AndroidNetworking.initialize(applicationContext)
        AndroidNetworking.enableLogging()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    fun getApplicationComponent(): ApplicationComponent {

        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(this))
                    .build()
        }

        return mApplicationComponent!!
    }
}