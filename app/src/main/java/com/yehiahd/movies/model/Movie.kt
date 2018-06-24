package com.yehiahd.movies.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(@SerializedName("results") val movies: List<Movie>,
                          @SerializedName("page") val page: Int,
                          @SerializedName("total_pages") val totalPages: Int,
                          @SerializedName("total_results") val totalResults: Int)

data class Movie(@SerializedName("vote_average") val voteAverage: Double,
                 @SerializedName("backdrop_path") val backdropPath: String,
                 @SerializedName("id") val id: Int,
                 @SerializedName("title") val title: String,
                 @SerializedName("popularity") val popularity: Double,
                 @SerializedName("poster_path") val posterPath: String,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("original_title") val originalTitle: String,
                 @SerializedName("original_language") val originalLanguage: String,
                 @SerializedName("vote_count") val voteCount: Int)