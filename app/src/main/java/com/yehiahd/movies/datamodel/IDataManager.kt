package com.yehiahd.movies.datamodel

import com.yehiahd.movies.model.MoviesResponse
import io.reactivex.Observable

interface IDataManager {

    fun getMoviesFromServerByType(type: String): Observable<MoviesResponse>
}