package com.example.parsexmlusingretrofit

import retrofit2.http.GET
import retrofit2.Call

interface FeedAPI {
    @get:GET("feed/")
    val feed: Call<RssFeed?>?

}