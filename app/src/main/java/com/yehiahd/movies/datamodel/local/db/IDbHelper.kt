package com.yehiahd.movies.datamodel.local.db

import com.yehiahd.movies.model.Movie
import io.reactivex.Flowable

interface IDbHelper {

    fun saveMovies(movies: List<Movie>)

    fun getMoviesByType(type: String): Flowable<List<Movie>>

    fun deleteMoviesByType(type: String)

}