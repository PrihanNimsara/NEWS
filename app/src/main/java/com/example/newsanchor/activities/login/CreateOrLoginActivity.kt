package com.example.newsanchor.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
import com.example.newsanchor.activities.LandingActivity
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_LOGIN_REQUEST_CODE
import kotlinx.android.synthetic.main.activity_create_or_login.*

class CreateOrLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_or_login)
        initUI()
    }

    private fun initUI() {
        val pageDescriptionText = "Select <b>Create account</b> if this is your first time or <b>Log in</b> if you already have an account. You can also <b>Explore projects</b> right away."
        pageDescription.text = HtmlCompat.fromHtml(pageDescriptionText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        createAccountButton.setOnClickListener { startActivityForResult(Intent(this, SelectAccountTypeActivity::class.java), ACCOUNT_TYPE_REQUEST_CODE) }
        loginButton.setOnClickListener { startActivityForResult(Intent(this, NewsAnchorLoginActivity::class.java), SETTING_UP_LOGIN_REQUEST_CODE)}

        layExploreProjects.setOnClickListener {
            startActivity(Intent(this, LandingActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( requestCode == SETTING_UP_LOGIN_REQUEST_CODE && resultCode == SETTING_UP_LOGIN_REQUEST_CODE){
            if (NewsAnchorDefaults.isInitialRun){
                startActivity(Intent(this, OnboardingActivity::class.java))
            } else {
                startActivity(Intent(this, LandingActivity::class.java))
            }
            finish()
        }

        if( requestCode == ACCOUNT_TYPE_REQUEST_CODE && resultCode == ACCOUNT_TYPE_REQUEST_CODE){
            finish()
        }
    }
}
