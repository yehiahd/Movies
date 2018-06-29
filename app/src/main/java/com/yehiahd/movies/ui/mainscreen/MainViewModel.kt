package com.yehiahd.movies.ui.mainscreen

import com.yehiahd.movies.datamodel.DataManager
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.ui.base.BaseViewModel
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel constructor(private val dataManager: DataManager) : BaseViewModel() {

    var movies: List<Movie>? = null

    fun getMoviesByType(type: String): Flowable<List<Movie>> {
        return dataManager.getMoviesFromDb(type)
                .flatMap {
                    if (it.isEmpty())
                        dataManager.getMoviesFromServerByType(type)
                    else
                        Flowable.just(it)
                }
                .flatMap {
                    this.movies = it
                    Flowable.just(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }

    fun getFavoriteMovies(): Flowable<List<Movie>> {
        return dataManager.getFavoriteMovies()
                .flatMap {
                    this.movies = it
                    Flowable.just(this.movies)
                }
    }
}