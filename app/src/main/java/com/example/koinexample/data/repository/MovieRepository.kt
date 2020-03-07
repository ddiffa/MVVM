package com.example.koinexample.data.repository

import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.data.model.MovieResponse
import io.reactivex.Observable
import io.reactivex.Single

interface MovieRepository {

    fun getNowPlaying(apiKey : String) : Single<List<MovieEntity>>

    fun getNowPlayingDb(): Single<List<MovieEntity>>

    fun saveNowPlayingMovie(movies : List<MovieEntity>)
}