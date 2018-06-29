package com.yehiahd.movies.datamodel

import com.yehiahd.movies.model.Movie
import io.reactivex.Flowable

interface IDataManager {

    fun getMoviesFromServerByType(type: String): Flowable<List<Movie>>

    fun getMoviesFromDb(type: String): Flowable<List<Movie>>

    fun getFavoriteMovies(): Flowable<List<Movie>>


}