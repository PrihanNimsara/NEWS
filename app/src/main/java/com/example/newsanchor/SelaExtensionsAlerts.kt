package com.example.newsanchor

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.andrognito.flashbar.Flashbar
import com.example.newsanchor.helpers.Const

/**
 * Created by K.I Prihan Nimsara on 2019-11-10.
 */

fun Activity.snackbarError(message: String){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Something is wrong")
        .message(message)
        .backgroundColor(Color.RED)
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}

fun Activity.snackbarSuccess(message: String){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title("Hooray")
        .message(message)
        .backgroundColor(ContextCompat.getColor(this,R.color.green_dark))
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}

fun Activity.snackbarSuccessCustom(title:String, message: String){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title(title)
        .message(message)
        .backgroundColor(ContextCompat.getColor(this,R.color.green_dark))
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}

fun Activity.snackbarErrorCustom(title:String, message: String){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title(title)
        .message(message)
        .backgroundColor(Color.RED)
        .duration(Flashbar.DURATION_LONG)
        .build()
        .show()
}

fun Activity.snackbarBlueWithExitAction(title:String, message: String, action: String, context: Context){
    Flashbar.Builder(this)
        .gravity(Flashbar.Gravity.TOP)
        .title(title)
        .message("\nHello citizen, we are Sela.\nPlease find the instructions below.\n${message}")
        .primaryActionText(" $action ")
        .primaryActionTapListener(object : Flashbar.OnActionTapListener {
            override fun onActionTapped(bar: Flashbar) {
                bar.dismiss()
                ((context) as Activity).setResult(Const.SUCCESSFUL_CREATE_ACCOUNT_CODE)
                (context).finish()
            }
        })
        .backgroundColor(ContextCompat.getColor(this,R.color.colorTitle))
        .build()
        .show()
}