package com.example.newsanchor

import android.annotation.SuppressLint
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
object BottomNavigationHelper {
    @SuppressLint("RestrictedApi")
    internal fun removeShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView

            item.setShifting(false)
            item.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED)
            item.setChecked(item.itemData.isChecked)
        }
    }
}