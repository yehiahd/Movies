package com.yehiahd.movies.ui.mainscreen

import com.yehiahd.movies.datamodel.DataManager
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.ui.base.BaseViewModel
import com.yehiahd.movies.util.Constant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}