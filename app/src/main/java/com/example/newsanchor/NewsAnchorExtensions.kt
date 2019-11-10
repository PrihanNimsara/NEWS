package com.example.newsanchor

import android.animation.Animator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

import java.text.SimpleDateFormat

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */

fun ImageView.load(url: Any) {
    val imageView = this

//    GlideApp.with(imageView.context)
//        .load(url)
//        .placeholder(R.color.cardTitle)
//        .into(this)
}

fun ImageView.load(url: Any, placeholder: Int) {
    val imageView = this

//    GlideApp.with(imageView.context)
//        .load(url)
//        .placeholder(placeholder)
//        .into(this)
}

fun Activity.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

@SuppressLint("SimpleDateFormat")
fun String.toDate(): String{
    val strDate = this
    val to = SimpleDateFormat("dd MMM yyyy") // wanted format
    val from = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") // current format

    return try{
        val d = from.parse(strDate)!!
        val dd = to.format(d)
        return dd
    } catch (e: Exception){
        "N/A"
    }

}

fun View.animateAlpha(duration: Long, alpha: Float, visibility: Int){
    val view = this
    view.animate()
        .alpha(alpha)
        .setDuration(duration)
        .setListener(object: Animator.AnimatorListener{
            override fun onAnimationRepeat(p0: Animator?) {}

            override fun onAnimationEnd(p0: Animator?) {
                view.visibility = visibility
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationStart(p0: Animator?) {}

        })
}


fun View.gone(){
    this.visibility = View.GONE
}

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}
