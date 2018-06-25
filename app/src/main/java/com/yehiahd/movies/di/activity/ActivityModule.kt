package com.yehiahd.movies.di.activity

import android.app.Application
import android.support.v7.widget.GridLayoutManager
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideLayoutManager(application: Application) = GridLayoutManager(application.applicationContext, 2)


}