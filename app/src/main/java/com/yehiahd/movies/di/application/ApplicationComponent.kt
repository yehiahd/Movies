package com.yehiahd.movies.di.application

import com.yehiahd.movies.app.MoviesApp
import com.yehiahd.movies.di.activity.ActivityComponent
import dagger.Component

@PerApplication
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(moviesApp: MoviesApp)

    fun newActivityComponent() : ActivityComponent
}