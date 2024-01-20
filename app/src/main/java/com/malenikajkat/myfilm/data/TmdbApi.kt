package com.malenikajkat.myfilm.data
import android.telecom.Call
import androidx.contentpager.content.Query
import com.malenikajkat.myfilm.data.Entity.TmdbResults
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("3/movie/popular")
    fun getFilms(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<TmdbResults>
}