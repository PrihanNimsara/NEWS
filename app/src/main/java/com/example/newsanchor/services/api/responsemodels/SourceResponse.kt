package com.example.newsanchor.services.api.responsemodels

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
data class SourceResponse (
    @SerializedName("name")
    var name : String
): Serializable
