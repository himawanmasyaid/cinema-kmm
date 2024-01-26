package com.hmwn.cinemakmm.data.remote

import com.hmwn.cinemakmm.data.model.MovieListResponse

interface KtorService {

    suspend fun getMovies(): MovieListResponse

}