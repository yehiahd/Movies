package com.yehiahd.movies.di.application

import android.app.Application
import com.yehiahd.movies.datamodel.DataManager
import com.yehiahd.movies.datamodel.remote.ApiHelper
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(application: Application) {

    private val mApplication: Application = application


    @Provides
    @PerApplication
    fun provideApplication() = mApplication

    @Provides
    @PerApplication
    fun provideDataManager(apiHelper: ApiHelper) = DataManager(apiHelper)

    @Provides
    @PerApplication
    fun provideApiHelper() = ApiHelper()

}