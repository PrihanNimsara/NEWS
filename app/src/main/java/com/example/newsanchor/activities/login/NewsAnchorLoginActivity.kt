package com.example.newsanchor.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
import com.example.newsanchor.activities.LandingActivity
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.empty
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_LOGIN_REQUEST_CODE
import com.example.newsanchor.snackbarErrorCustom
import com.example.newsanchor.snackbarSuccessCustom
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
            if(isUserCanLogin()) {
                val intent = Intent(this, LandingActivity::class.java)
                startActivityForResult(intent, SETTING_UP_LOGIN_REQUEST_CODE)
                overridePendingTransition(R.anim.slide_bottomlayer_display, R.anim.keep_active)

                NewsAnchorDefaults.isUserLogged = true
                snackbarSuccessCustom("Success!", "Welcome "+NewsAnchorDefaults.appUserName)
            }else{
                snackbarErrorCustom("Error!", "Login Failed")
            }
            }
    }

    private fun isUserCanLogin(): Boolean{
        var status = false
        val userEmailOrPhone = usernameEditText.text.toString().trim()
        val userPassowrd = passwordEditText.text.toString().trim()
        if(userEmailOrPhone.equals(NewsAnchorDefaults.appEmail)&& userPassowrd.equals(NewsAnchorDefaults.appPassword))
            status = true
        return status
    }
}
