package com.example.koinexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.koinexample.data.local.dao.MovieDao
import com.example.koinexample.data.local.entity.MovieEntity
import com.example.koinexample.util.Converter

@Database(entities = [MovieEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}