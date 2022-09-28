package com.jose.hackernews.data.network

import com.jose.hackernews.data.model.Hits
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HackerNewService @Inject constructor(private val api: HackerNewClient) {

    suspend fun  getAllHackerNews() : ArrayList<Hits> {
        return withContext(Dispatchers.IO){
            val response = api.getHackerNews()
            response.body()?.hits ?: ArrayList()
        }
    }
}