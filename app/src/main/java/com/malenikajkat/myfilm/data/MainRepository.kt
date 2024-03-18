package com.malenikajkat.myfilm.data
import com.malenikajkat.myfilm.data.dao.FilmDao
import com.malenikajkat.myfilm.data.entity.Film
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        filmDao.insertAll(films)
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}
