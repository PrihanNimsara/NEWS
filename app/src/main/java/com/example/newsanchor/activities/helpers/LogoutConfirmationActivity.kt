package com.example.newsanchor.activities.helpers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import com.example.newsanchor.R
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.gone
import com.example.newsanchor.helpers.Const.Companion.LOGOUT_CODE
import com.example.newsanchor.visible
import kotlinx.android.synthetic.main.activity_logout_confirmation.*

class LogoutConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_logout_confirmation)

        initUI()

        window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.color.transparent))
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }
    private fun initUI() {
        Handler().postDelayed({
            layContainer?.visible()
        }, 500)

        yesButton?.setOnClickListener {
            layContainer?.gone()
            Handler().postDelayed({
                layProgressRotation?.visible()
                NewsAnchorDefaults.isUserLogged = false
                NewsAnchorDefaults.isInitialRun = true
                NewsAnchorDefaults.appUserName = " "
                NewsAnchorDefaults.appEmail= " "
                NewsAnchorDefaults.appPassword = " "
            }, 200)

            Handler().postDelayed({
                setResult(LOGOUT_CODE)
                onBackPressed()
            }, 2000)
        }

        noButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.keep_active, R.anim.slide_display_bottom)
    }
}
