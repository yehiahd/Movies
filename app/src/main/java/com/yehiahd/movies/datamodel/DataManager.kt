package com.yehiahd.movies.datamodel

import com.yehiahd.movies.datamodel.remote.ApiHelper
import com.yehiahd.movies.model.MoviesResponse
import io.reactivex.Observable
import javax.inject.Inject

class DataManager @Inject constructor(private val mApiHelper: ApiHelper) : IDataManager {

    override fun getMoviesFromServerByType(type: String): Observable<MoviesResponse> {
        return mApiHelper.getMoviesByType(type)
    }

}
