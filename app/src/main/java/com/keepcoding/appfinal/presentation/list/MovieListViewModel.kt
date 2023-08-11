package com.keepcoding.appfinal.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.appfinal.domain.usecase.GetMovieListUseCase
import com.keepcoding.appfinal.domain.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> get() = _movieList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _errorMessage.value = null
            val result = withContext(Dispatchers.IO) {
                getMovieListUseCase.invoke()
            }
            _movieList.value = result
        }

        viewModelScope.launch {
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getMovieListUseCase.invoke()
                }
                _movieList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }
}