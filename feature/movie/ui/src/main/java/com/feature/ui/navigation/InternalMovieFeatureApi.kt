package com.feature.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.MovieFeature
import com.core.feature_api.FeatureApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.feature.ui.navigation.screen.MovieScreen
import com.feature.ui.navigation.screen.MovieViewModel

internal object InternalMovieFeatureApi :FeatureApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(
            startDestination = MovieFeature.MOVIE_SCREEN_ROUTE,
            route = MovieFeature.MOVIE_NESTED_ROUTE
        ) {
            composable(MovieFeature.MOVIE_SCREEN_ROUTE){
                val viewModel = hiltViewModel<MovieViewModel>()
                MovieScreen(viewModel = viewModel,navController)
            }
        }
    }
}