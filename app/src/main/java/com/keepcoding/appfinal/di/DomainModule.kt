package com.keepcoding.appfinal.di

import com.keepcoding.appfinal.domain.usecase.GetDetailUseCase
import com.keepcoding.appfinal.domain.usecase.GetMovieListUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetMovieListUseCase(get()) }
    single { GetDetailUseCase(get()) }
}
