package com.feature.ui.navigation.screen

import com.feature.domain.model.Movie

data class MovieScreenState(
    val isLoading : Boolean = false,
    val movieList : List<Movie> = emptyList(),
    val errorMessage : String? = null
)
