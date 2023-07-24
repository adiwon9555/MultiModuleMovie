package com.feature.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi
import javax.inject.Inject

interface MovieApi : FeatureApi {
}

class MovieApiImpl @Inject constructor() : MovieApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieFeatureApi.registerGraph(navController,navGraphBuilder)
    }
}