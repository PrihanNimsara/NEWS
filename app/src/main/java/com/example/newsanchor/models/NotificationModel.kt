package com.example.newsanchor.models

import android.os.Parcelable
import com.example.newsanchor.helpers.enums.NotificationType
import kotlinx.android.parcel.Parcelize

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

data class NotificationModel (
    val message: String = "N/A",
    val date: String = "",
    val icon: String = "",
    val type: NotificationType
)