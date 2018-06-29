package com.yehiahd.movies.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.yehiahd.movies.util.Constant
import kotlinx.android.parcel.Parcelize

data class MoviesResponse(@SerializedName("results") var movies: List<Movie>,
                          @SerializedName("page") var page: Int,
                          @SerializedName("total_pages") var totalPages: Int,
                          @SerializedName("total_results") var totalResults: Int)

@Parcelize
@Entity(tableName = Constant.DataBase.TABLE_NAME)
data class Movie(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = Constant.DataBase.ID_COLUMN_NAME) var uid: Int,
                 @SerializedName("vote_average") val voteAverage: Double,
                 @SerializedName("backdrop_path") var backdropPath: String,
                 @SerializedName("id") val id: Int,
                 @SerializedName("title") val title: String,
                 @SerializedName("popularity") val popularity: Double,
                 @SerializedName("poster_path") var posterPath: String,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("original_title") val originalTitle: String,
                 @SerializedName("original_language") val originalLanguage: String,
                 @SerializedName("vote_count") val voteCount: Int,
                 @ColumnInfo(name = Constant.DataBase.SECTION_TYPE_COLUMN_NAME) var sectionType: String) : Parcelable
