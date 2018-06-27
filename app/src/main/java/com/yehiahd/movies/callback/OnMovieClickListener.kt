package com.yehiahd.movies.callback

import com.yehiahd.movies.model.Movie

interface OnMovieClickListener {

    fun onMovieClicked(movie: Movie)
}