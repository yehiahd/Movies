package com.yehiahd.movies.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class MoviesResponse(@SerializedName("results") val movies: List<Movie>,
                          @SerializedName("page") val page: Int,
                          @SerializedName("total_pages") val totalPages: Int,
                          @SerializedName("total_results") val totalResults: Int)

@Parcelize
data class Movie(@SerializedName("vote_average") val voteAverage: Double,
                 @SerializedName("backdrop_path") var backdropPath: String,
                 @SerializedName("id") val id: Int,
                 @SerializedName("title") val title: String,
                 @SerializedName("popularity") val popularity: Double,
                 @SerializedName("poster_path") var posterPath: String,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("original_title") val originalTitle: String,
                 @SerializedName("original_language") val originalLanguage: String,
                 @SerializedName("vote_count") val voteCount: Int) : Parcelable