package com.yehiahd.movies.ui.mainscreen

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yehiahd.movies.R
import com.yehiahd.movies.databinding.ItemMovieBinding
import com.yehiahd.movies.model.Movie

class MoviesAdapter(private val context: Context, private val list: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val binding: ItemMovieBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_movie, parent, false)
        return MoviesHolder(binding)
    }

    override fun getItemCount() = list.size


    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.itemMovieBinding.movie = list[position]
    }

    class MoviesHolder(val itemMovieBinding: ItemMovieBinding)
        : RecyclerView.ViewHolder(itemMovieBinding.root)
}