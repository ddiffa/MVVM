package com.example.koinexample.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.koinexample.util.Converter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "now_playingdb")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("title")
    val title: String,
    @TypeConverters(Converter::class)
    @SerializedName("genre_ids")
    val genreIds: List<String>,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("vote_count")
    val voteCount: Double
)