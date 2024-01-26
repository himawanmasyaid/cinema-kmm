package com.hmwn.cinemakmm.di

import com.hmwn.cinemakmm.data.repository.MovieRepository
import com.hmwn.cinemakmm.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

fun repositoryModule() = module {

    single<MovieRepository> { MovieRepositoryImpl(get()) }

}