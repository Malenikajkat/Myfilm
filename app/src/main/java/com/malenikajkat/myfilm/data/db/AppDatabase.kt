package com.malenikajkat.myfilm.data.db
import androidx.room.Database
import androidx.room.RoomDatabase
import com.malenikajkat.myfilm.data.dao.FilmDao
import com.malenikajkat.myfilm.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}