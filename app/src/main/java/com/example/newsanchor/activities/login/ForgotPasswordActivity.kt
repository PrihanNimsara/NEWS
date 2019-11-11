package com.example.newsanchor.activities.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.andrognito.flashbar.Flashbar
import com.example.newsanchor.*
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.toolbar_with_back.*

class ForgotPasswordActivity : AppCompatActivity(){
    private var progressBar: Flashbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initUI()
    }

    private fun initUI() {
        progressBar = Flashbar.Builder(this)
            .gravity(Flashbar.Gravity.TOP)
            .title("\n\nPlease wait...")
            .message("We are validating your input.")
            .build()

        btnBack.setOnClickListener { onBackPressed() }
        submitButton.setOnClickListener { requestReset() }
    }

    private fun requestReset() {
        hideKeyboard()
        if (!usernameEditText.validEmail() && !usernameEditText.validPhone()) {
            snackbarErrorCustom("Error!", "Please enter a valid email address or phone number")
        } else {
            var email = ""
            var phone = ""

            if (usernameEditText.validPhone()) {
                phone = usernameEditText.text.toString()
            } else {
                email = usernameEditText.text.toString()
            }

            progressBar!!.show()
          // need to code  ResetPasswordSync(this).resetPasswordRequest(email, phone)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            );
        }
    }
}
