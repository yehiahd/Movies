package com.yehiahd.movies.datamodel.remote

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.yehiahd.movies.datamodel.local.db.DbHelper
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.model.MoviesResponse
import com.yehiahd.movies.util.Constant
import io.reactivex.Flowable
import io.reactivex.Observable

class ApiHelper(private val dbHelper: DbHelper) : IApiHelper {

    override fun getMoviesByType(type: String): Flowable<List<Movie>> {
        return Rx2AndroidNetworking.get(Constant.Api.BASE_URL + type)
                .addQueryParameter(Constant.Api.API_KEY_KEY, Constant.Api.API_KEY_VALUE)
                .build()
                .getObjectObservable(MoviesResponse::class.java)
                .flatMap { Observable.just(it.movies) }
                .flatMap { Observable.fromIterable(it) }
                .map { movie ->
                    with(movie) {
                        backdropPath = Constant.Api.BASE_IMAGE_URL + movie.backdropPath
                        posterPath = Constant.Api.BASE_IMAGE_URL + movie.posterPath
                        sectionType = type
                        movie
                    }
                }
                .toList()
                .toFlowable()
                .doOnNext { dbHelper.saveMovies(it) }
    }
}