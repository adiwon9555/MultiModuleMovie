package com.core.network

import com.core.network.di.NetworkModule
import com.core.network.dto.MovieResponse
import dagger.Component
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = API_KEY,
    ) : MovieResponse

    companion object {
        const val API_KEY = "02f440e85f7722d198a3559061c88d6f"
        const val BASE_URL = "https://api.themoviedb.org/"
    }
}