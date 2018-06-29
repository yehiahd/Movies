package com.yehiahd.movies.datamodel.remote

import com.yehiahd.movies.model.Movie
import io.reactivex.Flowable

interface IApiHelper {

    fun getMoviesByType(type: String): Flowable<List<Movie>>
}