package com.yehiahd.movies.datamodel.local.db

import android.content.Context
import com.yehiahd.movies.datamodel.local.db.dao.MoviesDao
import com.yehiahd.movies.datamodel.local.db.dao.MoviesDatabase
import com.yehiahd.movies.model.Movie
import io.reactivex.Flowable

class DbHelper(context: Context) : IDbHelper {

    private var moviesDao: MoviesDao = MoviesDatabase.getInstance(context).moviesDao

    override fun getMoviesByType(type: String): Flowable<List<Movie>> {
        return moviesDao.getMoviesBySection(type)
    }

    override fun saveMovies(movies: List<Movie>) {
        moviesDao.insertMovies(movies)
    }


    override fun deleteMoviesByType(type: String) {
        moviesDao.removeAllByType(type)
    }

}