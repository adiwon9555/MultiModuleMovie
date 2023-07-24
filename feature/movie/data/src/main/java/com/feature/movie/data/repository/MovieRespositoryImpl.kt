package com.feature.movie.data.repository

import com.core.network.ApiService
import com.core.network.dataproviders.MovieDataProviders
import com.feature.domain.model.Movie
import com.feature.domain.repository.MovieRepository
import com.feature.movie.data.di.DataModule
import com.feature.movie.data.mapper.toMovieList
import dagger.Component
import javax.inject.Inject

class MovieRespositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders
) : MovieRepository {
    override suspend fun getMovieList(query: String): List<Movie> {
        return movieDataProviders.getMovieList(query).toMovieList()
    }
}