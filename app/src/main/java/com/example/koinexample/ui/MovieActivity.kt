package com.example.koinexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.koinexample.R
import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.util.hide
import com.example.koinexample.util.loadImage
import com.example.koinexample.util.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.architecture.ext.viewModel

class MovieActivity : AppCompatActivity(), MovieContract.View {

    private val viewModel by viewModel<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.apply {
            isLoading.observe(this@MovieActivity, Observer<Boolean> { isLoading ->
                observeLoading(isLoading)
            })
            isError.observe(this@MovieActivity, Observer<Throwable> { error ->
                observeError(error)
            })
            movie.observe(this@MovieActivity, Observer<MovieEntity> { movie ->
                observeNowPlaying(movie)
            })
        }

        viewModel.getNowPlayingMovie("ac313fc1138a0ed697567a0dedddc6cd")
    }

    override fun observeLoading(isLoading: Boolean?) {
        isLoading?.let {
            if (it) {
                progressBar.visible()
            } else {
                progressBar.hide()
            }
        }
    }

    override fun observeError(error: Throwable?) {
        error?.let { toast(it.message.toString()) }
    }

    override fun observeNowPlaying(movie: MovieEntity) {
        movie?.let {
            imagePoster.loadImage("https://image.tmdb.org/t/p/w500/${it.posterPath}")
            tvTitle.text = it.title
        }
    }
}
