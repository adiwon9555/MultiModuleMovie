package com.feature.ui.navigation.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UIEvent
import com.feature.domain.use_cases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val getMovieListUseCase: GetMovieListUseCase
) : ViewModel(){
    private val _movieScreenState = MutableStateFlow(MovieScreenState())
    val movieScreenState = _movieScreenState.asStateFlow()

    private val _query = MutableStateFlow(String())
    val query = _query.asStateFlow()

    fun setSearchQuery(query: String){
        _query.value = query
    }

    init {
        viewModelScope.launch {
            query.debounce(1000).collectLatest {
                getAllMovieList(it)
            }
        }
    }


    fun getAllMovieList(query: String) = viewModelScope.launch{
        Log.d("collect","@aditya ${query}")
        getMovieListUseCase.invoke(query)
            .collect{uiEvent ->
                Log.d("uiEvent","@aditya ${uiEvent.toString()}")
                when(uiEvent){
                    is UIEvent.Error -> {
                        _movieScreenState.update {
                            it.copy(
                                errorMessage = uiEvent.message
                            )
                        }
                    }
                    is UIEvent.Loading -> {
                        Log.d("uiEvent","@aditya ${uiEvent.isLoading}")
                        _movieScreenState.update {
                            it.copy(
                                isLoading = uiEvent.isLoading
                            )
                        }
                    }
                    is UIEvent.Success -> {
                        uiEvent.data?.let { movieList ->
                            _movieScreenState.update {
                                it.copy(
                                    movieList = movieList
                                )
                            }
                        }

                    }
                }
            }
    }


}