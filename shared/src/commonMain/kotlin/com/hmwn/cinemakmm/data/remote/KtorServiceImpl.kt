package com.hmwn.cinemakmm.data.remote

import com.hmwn.cinemakmm.data.model.MovieListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class KtorServiceImpl(
    private val httpClient: HttpClient
): KtorService {

    override suspend fun getMovies(): MovieListResponse = httpClient.get(
        "discover/movie"
    ).body()
}