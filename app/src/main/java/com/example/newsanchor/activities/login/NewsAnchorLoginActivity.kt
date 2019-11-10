package com.example.newsanchor.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
import com.example.newsanchor.activities.LandingActivity
import com.example.newsanchor.empty
import com.example.newsanchor.helpers.Const
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_LOGIN_REQUEST_CODE
import com.example.newsanchor.snackbarErrorCustom
import kotlinx.android.synthetic.main.activity_news_anchor_login.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class NewsAnchorLoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_anchor_login)

        initUI()
    }

    private fun initUI() {
        val dontHaveAccountText = "Don't have an account? <b>Create account</b>"
        dontHaveAccount.text =
            HtmlCompat.fromHtml(dontHaveAccountText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        btnBack.setOnClickListener { onBackPressed() }
        loginButton.setOnClickListener { sendLoginData() }

        forgotPassword.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    ForgotPasswordActivity::class.java
                )
            )
        }
        dontHaveAccount.setOnClickListener {
            startActivityForResult(
                Intent(
                    this,
                    SelectAccountTypeActivity::class.java
                ),
                ACCOUNT_TYPE_REQUEST_CODE
            )
        }

    }

    private fun sendLoginData() {
        if (usernameEditText.empty()) {
            snackbarErrorCustom("Error!", "Username field is empty")
        } else if (passwordEditText.empty()) {
            snackbarErrorCustom("Error!", "Password field is empty")
        } else {
            val intent = Intent(this, LandingActivity::class.java)
//            intent.putExtra(Const.SETTING_UP_TYPE, SettingUpRequestType.LOGIN)
//            intent.putExtra(Const.USERNAME, usernameEditText.text.toString())
//            intent.putExtra(Const.PASSWORD, passwordEditText.text.toString())
//
            startActivityForResult(intent, SETTING_UP_LOGIN_REQUEST_CODE)
            overridePendingTransition(R.anim.slide_bottomlayer_display, R.anim.keep_active)
        }
    }


}
