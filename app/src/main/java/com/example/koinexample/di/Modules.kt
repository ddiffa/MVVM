package com.example.koinexample.di

import androidx.room.Room
import com.example.koinexample.data.local.MovieDb
import com.example.koinexample.data.remote.MovieAPI
import com.example.koinexample.data.repository.impl.MovieRepositoryImpl
import com.example.koinexample.ui.MovieInteractor
import com.example.koinexample.ui.MovieViewModel
import com.example.koinexample.util.SchedulerProvider
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {

    factory { MovieInteractor(get()) }
    viewModel { MovieViewModel(get(), get()) }

    bean { MovieAPI.create() }
    bean { SchedulerProvider() }
    bean { MovieRepositoryImpl(get(), get()) }

    bean {
        Room.databaseBuilder(androidApplication(), MovieDb::class.java, "Moviedb").build()
    }

    bean { get<MovieDb>().movieDao() }

}