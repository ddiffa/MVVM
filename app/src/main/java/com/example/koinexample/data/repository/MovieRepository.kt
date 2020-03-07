package com.example.koinexample.data.repository

import com.example.koinexample.data.model.MovieResponse
import io.reactivex.Observable

interface MovieRepository {

    fun getNowPlaying(apiKey : String) : Observable<MovieResponse>

    fun getNowPlayingDb(): Observable<List<MovieResponse>>

    fun saveNowPlayingMovie(movie : MovieResponse)
}