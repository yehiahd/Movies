package com.yehiahd.movies.datamodel.local.db.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.yehiahd.movies.model.Movie
import com.yehiahd.movies.util.Constant

@Database(entities = [Movie::class], version = 2, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract val moviesDao: MoviesDao


    companion object {
        private var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context): MoviesDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MoviesDatabase::class.java, Constant.DataBase.DATA_BASE_NAME)
                        .build()
            }

            return INSTANCE!!
        }

    }
}