package com.feature.movie.data.di

import com.core.network.ApiService
import com.core.network.dataproviders.MovieDataProviders
import com.feature.domain.repository.MovieRepository
import com.feature.movie.data.repository.MovieRespositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRespositoryImpl: MovieRespositoryImpl
    ) : MovieRepository

}