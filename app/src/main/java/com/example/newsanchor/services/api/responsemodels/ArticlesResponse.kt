package com.example.newsanchor.services.api.responsemodels

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

data class ArticlesResponse(
    @SerializedName("source")
    var source: SourceResponse,
    @SerializedName("author")
    var author: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("content")
    var content: String
):Serializable