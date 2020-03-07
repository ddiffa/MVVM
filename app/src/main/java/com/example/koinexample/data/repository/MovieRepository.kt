package com.example.koinexample.data.repository

import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.data.model.MovieResponse
import io.reactivex.Observable

interface MovieRepository {

    fun getNowPlaying(apiKey : String) : Observable<List<MovieEntity>>

    fun getNowPlayingDb(): Observable<List<MovieEntity>>

    fun saveNowPlayingMovie(movies : List<MovieEntity>)
}