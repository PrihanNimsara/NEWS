package com.example.newsanchor.services.api.responsemodels

import com.google.gson.annotations.SerializedName

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class News {
    @SerializedName("status")
    var status: String? = null

    @SerializedName("totalResults")
    var totalResults: Int? = null
}