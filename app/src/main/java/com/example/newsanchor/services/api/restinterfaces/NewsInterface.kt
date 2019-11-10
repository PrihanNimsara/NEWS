package com.example.newsanchor.services.api.restinterfaces

import com.example.newsanchor.services.api.responsemodels.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
interface NewsInterface {
    @GET("top-headlines")
    fun getTopHeadlineList(@Query("country") country: String,@Query("apiKey") apiKey: String) : Call<NewsResponse>

    @GET("everything")
    fun getCustomNews(@Query("q") q: String,@Query("apiKey") apiKey: String) : Call<NewsResponse>
}