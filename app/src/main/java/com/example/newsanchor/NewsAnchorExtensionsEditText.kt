package com.example.newsanchor

import android.text.TextUtils
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText

/**
 * Created by K.I Prihan Nimsara on 2019-11-10.
 */
fun EditText.empty():Boolean {
    return TextUtils.isEmpty(this.text.toString())
}

fun EditText.validEmail():Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
}

fun EditText.validPhone():Boolean {
    return android.util.Patterns.PHONE.matcher(this.text.toString()).matches()
}

fun AppCompatEditText.empty():Boolean {
    return TextUtils.isEmpty(this.text.toString())
}