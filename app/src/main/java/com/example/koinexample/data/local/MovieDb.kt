package com.example.koinexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koinexample.data.local.dao.MovieDao
import com.example.koinexample.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}