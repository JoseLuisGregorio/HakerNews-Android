package com.jose.hackernews.data

import com.jose.hackernews.data.model.HackerNewProvider
import com.jose.hackernews.data.model.Hits
import com.jose.hackernews.data.network.HackerNewService
import javax.inject.Inject

class HackerNewRepository @Inject constructor(
    private val api: HackerNewService,
    private val hackerNewProvider: HackerNewProvider
) {
    suspend fun getAllHackerNews(): ArrayList<Hits> {
        val response = api.getAllHackerNews()
        hackerNewProvider.hackerNews = response
        return response
    }
}
