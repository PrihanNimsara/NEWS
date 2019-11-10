package com.example.newsanchor.models

import android.os.Parcelable
import com.example.newsanchor.helpers.enums.SelaCellType
import kotlinx.android.parcel.Parcelize

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

data class YourTaskModel (
    val title: String = "",
    val type: String = "",
    val assigner: String = "",
    val assignerName: String = "",
    val dueDate: String = "",
    val isSubmitted: Boolean = false,
    val cellType: SelaCellType = SelaCellType.DATA
)