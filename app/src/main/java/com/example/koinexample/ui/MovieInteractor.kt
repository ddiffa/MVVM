package com.example.koinexample.ui

import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.data.repository.impl.MovieRepositoryImpl
import io.reactivex.Single

class MovieInteractor(private val repository: MovieRepositoryImpl) : MovieContract.Interactor {

    override fun getNowPlayingMovie(apiKey: String): Single<List<MovieEntity>> {
        return Single.concat(diskWithCache, getNetworkWithSave(apiKey))
            .filter { movie -> movie.isNotEmpty() }
            .first(ArrayList())

    }

    private fun getNetworkWithSave(apiKey: String): Single<List<MovieEntity>> {
        return repository.getNowPlaying(apiKey).doOnSuccess { repository.saveNowPlayingMovie(it) }
    }

    private var diskWithCache = repository.getNowPlayingDb()
}