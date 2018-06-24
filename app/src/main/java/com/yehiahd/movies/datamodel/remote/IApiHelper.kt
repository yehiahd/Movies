package com.yehiahd.movies.datamodel.remote

import com.yehiahd.movies.model.MoviesResponse
import io.reactivex.Observable

interface IApiHelper {

    fun getMoviesByType(type: String): Observable<MoviesResponse>
}