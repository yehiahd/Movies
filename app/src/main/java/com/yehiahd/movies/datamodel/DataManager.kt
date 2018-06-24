package com.yehiahd.movies.datamodel

import com.yehiahd.movies.datamodel.remote.ApiHelper
import com.yehiahd.movies.model.MoviesResponse
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(apiHelper: ApiHelper) : IDataManager {

    private val mApiHelper = apiHelper

    override fun getMoviesFromServerByType(type: String): Observable<MoviesResponse> {
        return mApiHelper.getMoviesByType(type)
    }

}
