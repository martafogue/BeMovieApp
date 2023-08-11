package com.keepcoding.appfinal.di

import com.keepcoding.appfinal.presentation.detail.MovieDetailViewModel
import com.keepcoding.appfinal.presentation.list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
}
