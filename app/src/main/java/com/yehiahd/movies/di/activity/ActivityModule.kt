package com.yehiahd.movies.di.activity

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule {

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

}