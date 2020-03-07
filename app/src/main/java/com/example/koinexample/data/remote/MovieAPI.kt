package com.example.koinexample.data.remote

import com.example.koinexample.data.model.MovieResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface MovieAPI {

    @GET("movie/now_playing")
    fun getNowPlaying(@Query("api_key") apiKey: String): Observable<MovieResponse>

    companion object Factory {
        fun create(): MovieAPI {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(
                    makeLoggingInterceptor(
                        true
                    )
                )
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(MovieAPI::class.java)
        }

        private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.level =
                if (isDebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            return logging
        }
    }

}