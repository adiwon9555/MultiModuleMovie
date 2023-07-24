package com.example.moviemultimodule.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.MovieFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(navController = navController, startDestination = MovieFeature.MOVIE_NESTED_ROUTE){
        navigationProvider.movieApi.registerGraph(
            navController = navController,
            this
        )
    }
}