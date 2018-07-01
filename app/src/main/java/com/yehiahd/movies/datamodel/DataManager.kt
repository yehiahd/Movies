package com.yehiahd.movies.datamodel

import com.yehiahd.movies.datamodel.local.db.DbHelper
import com.yehiahd.movies.datamodel.remote.ApiHelper
import com.yehiahd.movies.model.Movie
import io.reactivex.Flowable
import javax.inject.Inject

class DataManager @Inject constructor(private val mApiHelper: ApiHelper, private val mDbHelper: DbHelper) : IDataManager {


    override fun getMoviesFromServerByType(type: String): Flowable<List<Movie>> {
        return mApiHelper.getMoviesByType(type)
    }

    override fun getMoviesFromDb(type: String): Flowable<List<Movie>> {
        return mDbHelper.getMoviesByType(type)
    }

    override fun deleteMoviesByType(type: String) {
        mDbHelper.deleteMoviesByType(type)
    }
}
