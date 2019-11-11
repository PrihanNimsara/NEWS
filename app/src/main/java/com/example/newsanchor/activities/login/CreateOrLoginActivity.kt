package com.example.newsanchor.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
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

        createAccountButton.setOnClickListener {
            startActivity(Intent(this, SelectAccountTypeActivity::class.java))
        }
        loginButton.setOnClickListener {
            startActivity(Intent(this, NewsAnchorLoginActivity::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

