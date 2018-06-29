package com.yehiahd.movies.util

object Constant {


    object Api {
        const val BASE_URL = "https://api.themoviedb.org/3/movie/"
        const val POPULAR = "popular"
        const val TOP_RATED = "top_rated"
        const val API_KEY_KEY = "api_key"
        const val API_KEY_VALUE = "6ba7581f4330b87ceabc4ef8212ed72b"
        const val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/"
    }

    object Extra {
        const val MOVIE = "movie"
    }

    object DataBase {
        const val DATA_BASE_NAME = "movies_db"
        const val TABLE_NAME = "movies_table"
        const val ID_COLUMN_NAME = "uid"
        const val SECTION_TYPE_COLUMN_NAME = "section_type"
        const val IS_FAVORITE_COLUMN_NAME = "is_favorite"
    }
}