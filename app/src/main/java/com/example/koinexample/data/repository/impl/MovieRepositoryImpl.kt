package com.example.koinexample.data.repository.impl

import com.example.koinexample.data.local.dao.MovieDao
import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.data.remote.MovieAPI
import com.example.koinexample.data.repository.MovieRepository
import io.reactivex.Observable
import io.reactivex.Single

class MovieRepositoryImpl(
    private val movieAPI: MovieAPI,
    private val movieDao: MovieDao
) : MovieRepository {

    override fun getNowPlaying(apiKey: String): Single<List<MovieEntity>> {
        return movieAPI.getNowPlaying(apiKey).map { it.results }
    }

    override fun getNowPlayingDb(): Single<List<MovieEntity>> {
        return movieDao.getNowPlayingMovie()
    }

    override fun saveNowPlayingMovie(movies: List<MovieEntity>) {
        for (movie in movies) {
            movieDao.insertMovie(movie)
        }
    }
}