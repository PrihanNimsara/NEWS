package com.example.newsanchor.services.sync

import com.example.newsanchor.helpers.Const
import com.example.newsanchor.services.api.ServiceGenerator
import com.example.newsanchor.services.api.responsemodels.NewsResponse
import com.example.newsanchor.services.api.restinterfaces.NewsInterface
import com.google.gson.JsonParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class CustomNewsSync(private val callback:CustomeNewsCallback,private val searchType : String) {
    fun list() {
        ServiceGenerator.createService(NewsInterface::class.java).getCustomNews(searchType, Const.API_KEY)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            val dataset = response.body()!!
                            if (dataset != null) {
                                callback.onCustomeNewsFound(true, dataset, "No news available")
                            } else {
                                callback.onCustomeNewsFound(true, null, "No news available")
                            }
                        } else {
                            callback.onCustomeNewsFound(false, null, "Failed to load news")
                        }
                    } else {
                        try {
                            if (response.errorBody() != null) {
                                val errorJsonString = response.errorBody()?.string()
                                val message = JsonParser().parse(errorJsonString)
                                    .asJsonObject["message"]
                                    .asString

                                callback.onCustomeNewsFound(false, null, message)
                            } else {
                                callback.onCustomeNewsFound(false, null, "Failed to load projects")
                            }

                        } catch (e: Exception) {
                            callback.onCustomeNewsFound(false, null, "Failed to load projects")
                        }
                    }
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    callback.onCustomeNewsFound(false, null, "Failed to load news. Something wrong with servers"
                    )
                }
            })
    }

    interface CustomeNewsCallback{
        fun onCustomeNewsFound(status: Boolean, response: NewsResponse?, message: String)
    }
}