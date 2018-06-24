package com.yehiahd.movies.ui.mainscreen

import android.util.Log
import com.yehiahd.movies.datamodel.DataManager
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.ui.base.BaseViewModel
import com.yehiahd.movies.util.Constant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataManager: DataManager) : BaseViewModel() {

    fun logAnyThing() {
        dataManager.getMoviesFromServerByType(Constant.Api.POPULAR)
        Log.d("Hello From DI", "Dagger 2")
    }

    fun getMoviesByType(type: String): Observable<List<Movie>> {
        return dataManager.getMoviesFromServerByType(type)
                .flatMap { Observable.just(it.movies) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

    }
}