package com.jose.hackernews.data.network

import com.jose.hackernews.data.model.HackerNewsDTO
import retrofit2.Response
import retrofit2.http.GET

interface HackerNewClient {
    @GET ("/api/v1/search_by_date?query=android")
    suspend fun getHackerNews() : Response<HackerNewsDTO>
}