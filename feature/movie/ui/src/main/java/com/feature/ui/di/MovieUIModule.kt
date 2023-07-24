package com.feature.ui.di

import com.feature.ui.navigation.MovieApi
import com.feature.ui.navigation.MovieApiImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieUIModule {

    @Binds
    @Singleton
    abstract fun provideMovieApi(
        movieApiImpl: MovieApiImpl
    ) : MovieApi
}