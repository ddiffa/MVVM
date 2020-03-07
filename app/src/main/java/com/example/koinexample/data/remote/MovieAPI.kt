package com.example.koinexample.data.remote

import com.example.koinexample.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET("movie/now_playing")
    fun getNowPlaying(@Query("api_key") apiKey: String): Single<MovieResponse>

    companion object Factory {
        fun create(): MovieAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MovieAPI::class.java)
        }

    }

}