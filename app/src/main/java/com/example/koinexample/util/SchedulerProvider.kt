package com.example.koinexample.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider {

    fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    fun io(): Scheduler {
        return Schedulers.io()
    }

    fun computation(): Scheduler {
        return Schedulers.computation()
    }
}