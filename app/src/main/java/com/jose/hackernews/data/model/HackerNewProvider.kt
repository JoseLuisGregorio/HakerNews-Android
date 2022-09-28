package com.jose.hackernews.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HackerNewProvider @Inject constructor() {
    var hackerNews :ArrayList<Hits> = ArrayList()
}