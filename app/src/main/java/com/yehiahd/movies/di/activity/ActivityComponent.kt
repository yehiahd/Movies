package com.yehiahd.movies.di.activity

import com.yehiahd.movies.ui.mainscreen.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}