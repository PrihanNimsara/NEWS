package com.example.newsanchor.helpers.ui

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.IdRes
import com.example.newsanchor.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
object BottomMenuHelper {
    fun showBadge(
        context: Context,
        bottomNavigationView: BottomNavigationView, @IdRes itemId: Int,
        value: String
    ) {
        removeBadge(bottomNavigationView, itemId)
        val itemView = bottomNavigationView.findViewById<BottomNavigationItemView>(itemId)
        val badge = LayoutInflater.from(context).inflate(R.layout.badge_layout, bottomNavigationView, false)

        val text = badge.findViewById<TextView>(R.id.badge_text_view)
        text.text = value
        itemView.addView(badge)
    }

    fun removeBadge(bottomNavigationView: BottomNavigationView, @IdRes itemId: Int) {
        try{
            val itemView = bottomNavigationView.findViewById<BottomNavigationItemView>(itemId)
            itemView.removeViewAt(2)
        } catch (e: Exception){
            print("Error - ${e}")
        }
    }
}