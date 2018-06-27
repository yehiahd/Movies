package com.yehiahd.movies.ui.mainscreen

import com.yehiahd.movies.datamodel.DataManager
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.ui.base.BaseViewModel
import com.yehiahd.movies.util.Constant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel constructor(private val dataManager: DataManager) : BaseViewModel() {

    var movies: List<Movie>? = null

    fun getMoviesByType(type: String): Observable<List<Movie>> {
        return dataManager.getMoviesFromServerByType(type)
                .flatMap { Observable.just(it.movies) }
                .flatMap { Observable.fromIterable(it) }
                .map { movie ->
                    with(movie) {
                        backdropPath = Constant.Api.BASE_IMAGE_URL + movie.backdropPath
                        posterPath = Constant.Api.BASE_IMAGE_URL + movie.posterPath
                        movie
                    }
                }
                .toList()
                .toObservable()
                .flatMap {
                    this.movies = it
                    Observable.just(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}