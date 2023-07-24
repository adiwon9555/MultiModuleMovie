package com.core.network.dataproviders

import com.core.network.ApiService
import com.core.network.dto.MovieResponse
import dagger.Provides
import retrofit2.http.Query
import javax.inject.Inject

class MovieDataProviders @Inject constructor(
    val apiService: ApiService
) {

    suspend fun getMovieList(
        query: String
    ) : MovieResponse  = apiService.getMovieList(query)

}