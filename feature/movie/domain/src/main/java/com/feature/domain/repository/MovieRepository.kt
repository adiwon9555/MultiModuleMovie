package com.feature.domain.repository

import com.feature.domain.model.Movie
import dagger.Component

interface MovieRepository {
    suspend fun getMovieList(query : String) : List<Movie>
}