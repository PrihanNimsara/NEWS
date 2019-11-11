package com.example.newsanchor.helpers

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView

/**
 * Created by K.I Prihan Nimsara on 2019-11-11.
 */
class NewsAnchorRotatingImageView : AppCompatImageView {

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onFinishInflate() {
        super.onFinishInflate()

        // Set and scale the image
//        setImageResource(IMAGE_RESOURCE_ID)

        // Start the animation
        startAnimation()
    }

    /**
     * Starts the rotate animation.
     */
    private fun startAnimation() {
        clearAnimation()

        val rotate = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotate.duration = ROTATE_ANIMATION_DURATION.toLong()
        rotate.repeatCount = Animation.INFINITE
        startAnimation(rotate)
    }

    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)

        if (visibility == View.VISIBLE) {
            startAnimation()
        } else {
            clearAnimation()
        }
    }

    companion object {

        private val ROTATE_ANIMATION_DURATION = 2500
//        private var IMAGE_RESOURCE_ID = R.drawable.logo
    }
}
