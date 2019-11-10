package com.example.newsanchor.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
data class ProjectModel (
    val title: String = "",
    val fundPercentage: String = "",
    val location: String = "",
    val status: String = "",
    val amount: String = "",
    val bannerImage: String = "",
    var id: String = ""
)