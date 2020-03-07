package com.example.koinexample.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.util.SchedulerProvider

class MovieViewModel(
    private val interactor: MovieInteractor,
    private val scheduler: SchedulerProvider
) : ViewModel(), MovieContract.ViewModel {

    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()
    val movie = MutableLiveData<MovieEntity>()

    @SuppressLint("CheckResult")
    override fun getNowPlayingMovie(apiKey: String) {
        isLoading.postValue(true)
        interactor.getNowPlayingMovie(apiKey)
            .observeOn(scheduler.ui())
            .subscribeOn(scheduler.io())
            .subscribe({ result ->
                isLoading.postValue(false)
                movie.postValue(result[0])
            }, { error ->
                isLoading.postValue(false)
                isError.postValue(error)
            })
    }
}