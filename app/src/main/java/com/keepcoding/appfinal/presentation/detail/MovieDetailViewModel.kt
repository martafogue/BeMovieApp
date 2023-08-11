package com.keepcoding.appfinal.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.appfinal.domain.MovieModel
import com.keepcoding.appfinal.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
) : ViewModel() {

    private val _movie = MutableLiveData<MovieModel>()
    val movie: LiveData<MovieModel> get() = _movie

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getMovie(id: Int) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _movie.value = result
        } catch (t: Throwable) {
            _errorMessage.value = t.toString()
        }
    }
}