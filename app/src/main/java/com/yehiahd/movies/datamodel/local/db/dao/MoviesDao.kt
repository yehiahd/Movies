package com.yehiahd.movies.datamodel.local.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.util.Constant
import io.reactivex.Flowable

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movies: List<Movie>)

    @Query("SELECT * FROM ${Constant.DataBase.TABLE_NAME} WHERE ${Constant.DataBase.SECTION_TYPE_COLUMN_NAME} LIKE :moviesSection")
    fun getMoviesBySection(moviesSection: String): Flowable<List<Movie>>

    @Query("DELETE FROM ${Constant.DataBase.TABLE_NAME} WHERE ${Constant.DataBase.SECTION_TYPE_COLUMN_NAME} LIKE :type")
    fun removeAllByType(type: String)
}