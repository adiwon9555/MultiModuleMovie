package com.feature.domain.di

import com.feature.domain.repository.MovieRepository
import com.feature.domain.use_cases.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object MovieDomainLayerModule {


}