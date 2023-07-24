package com.feature.domain.use_cases

import com.core.common.UIEvent
import com.feature.domain.model.Movie
import com.feature.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieRespositoryImpl: MovieRepository
) {
    operator fun invoke(query: String) = flow {
        emit(UIEvent.Loading(true))
        emit(UIEvent.Success(movieRespositoryImpl.getMovieList(query)))
        emit(UIEvent.Loading(false))
    }.catch {
        emit(UIEvent.Error(it.message.toString()))
        emit(UIEvent.Loading(false))
    }.flowOn(Dispatchers.IO)

}