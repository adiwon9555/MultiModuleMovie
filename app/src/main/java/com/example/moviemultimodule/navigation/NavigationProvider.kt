package com.example.moviemultimodule.navigation

import com.feature.ui.navigation.MovieApi
import javax.inject.Inject

data class NavigationProvider @Inject constructor(
    val movieApi: MovieApi,
)