package com.example.koinexample.data.local.dao

import androidx.room.*
import com.example.koinexample.data.local.entity.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {

    @Query("SELECT * FROM now_playingdb")
    fun getNowPlayingMovie(): Single<List<MovieEntity>>

    @Insert
    fun insertMovie(vararg movie: MovieEntity)

    @Update
    fun updateMovie(vararg movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)
}