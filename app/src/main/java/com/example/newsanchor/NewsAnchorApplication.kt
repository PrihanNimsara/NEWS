package com.example.newsanchor

import android.app.Application
import com.chibatching.kotpref.Kotpref

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class NewsAnchorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Kotpref.init(this)
    }
}