package com.example.koinexample.ui

import com.example.koinexample.data.local.entity.MovieEntity
import io.reactivex.Single

interface MovieContract {

    interface View {
        fun observeLoading(isLoading: Boolean?)

        fun observeError(error: Throwable?)

        fun observeNowPlaying(movie: MovieEntity)
    }

    interface ViewModel {

        fun getNowPlayingMovie(apiKey: String)
    }

    interface Interactor {
        fun getNowPlayingMovie(apiKey: String): Single<List<MovieEntity>>
    }
}