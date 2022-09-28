package com.jose.hackernews.domain

import com.jose.hackernews.data.HackerNewRepository
import com.jose.hackernews.data.model.Hits
import javax.inject.Inject

class GetHackerNewsUseCase @Inject constructor(
    private val repository: HackerNewRepository
) {
    suspend operator fun invoke(): ArrayList<Hits> = repository.getAllHackerNews()
}