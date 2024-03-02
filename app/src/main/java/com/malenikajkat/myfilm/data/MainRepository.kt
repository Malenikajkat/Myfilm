package com.malenikajkat.myfilm.data

import androidx.lifecycle.LiveData
import com.malenikajkat.myfilm.data.dao.FilmDao
import com.malenikajkat.myfilm.data.entity.Film
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        //Запросы в бд должны быть в отдельном потоке
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): LiveData<List<Film>> = filmDao.getCachedFilms()

}
