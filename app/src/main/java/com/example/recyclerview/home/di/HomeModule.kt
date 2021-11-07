package com.example.recyclerview.home.di

import com.example.recyclerview.BASE_URL
import com.example.recyclerview.home.data.mapper.MovieResponseMapper
import com.example.recyclerview.home.data.repository.BaseMovieRepository
import com.example.recyclerview.home.data.source.MovieNetworkSource
import com.example.recyclerview.home.domain.repository.MovieRepository
import com.example.recyclerview.home.domain.usecase.GetMovieUseCase
import com.example.recyclerview.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal val homeModule: Module = module {
    single {
        BaseMovieRepository(
            movieNetworkSource = get(),
            movieResponseMapper = get()
        ) as MovieRepository
    }

    single {
        MovieResponseMapper()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(MovieNetworkSource::class.java)
    }

    factory {
        GetMovieUseCase(
            movieRepository = get()
        )
    }

    viewModel {
        HomeViewModel(
            getMovieUseCase = get()
        )
    }
}