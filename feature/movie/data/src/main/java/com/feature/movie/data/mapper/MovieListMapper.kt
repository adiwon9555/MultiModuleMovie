package com.feature.movie.data.mapper

import com.core.network.dto.MovieItem
import com.core.network.dto.MovieResponse
import com.feature.domain.model.Movie

fun MovieResponse.toMovieList(): List<Movie> {
    return this.results.mapNotNull { movieItem ->
        Movie(
            imageUrl = movieItem.posterPath?.let { makeFullPath(it) } ?: return@mapNotNull null,
            id = movieItem.id
        )
    }
}

fun makeFullPath(path : String) : String{
    return "https://image.tmdb.org/t/p/w500${path}"
}