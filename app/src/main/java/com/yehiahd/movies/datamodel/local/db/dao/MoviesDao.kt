package com.yehiahd.movies.datamodel.local.db.dao

import android.arch.persistence.room.*
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.util.Constant
import io.reactivex.Flowable

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movies: List<Movie>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateMovies(vararg movies: Movie)

    @Query("SELECT * FROM ${Constant.DataBase.TABLE_NAME} WHERE ${Constant.DataBase.SECTION_TYPE_COLUMN_NAME} LIKE :moviesSection")
    fun getMoviesBySection(moviesSection: String): Flowable<List<Movie>>

    @Query("SELECT * FROM ${Constant.DataBase.TABLE_NAME} WHERE ${Constant.DataBase.IS_FAVORITE_COLUMN_NAME} = 1")
    fun getFavoriteMovies(): Flowable<List<Movie>>

}