package com.example.newsanchor.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.newsanchor.*
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.helpers.Const
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE
import com.example.newsanchor.helpers.Const.Companion.EMAIL
import com.example.newsanchor.helpers.Const.Companion.ERROR
import com.example.newsanchor.helpers.Const.Companion.FIRST_NAME
import com.example.newsanchor.helpers.Const.Companion.LAST_NAME
import com.example.newsanchor.helpers.Const.Companion.PASSWORD
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_REGISTER_REQUEST_CODE
import com.example.newsanchor.helpers.enums.AccountType
import com.example.newsanchor.helpers.enums.SettingUpRequestType
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.toolbar_with_back.*

class CreateAccountActivity : AppCompatActivity() {


    var accountType = AccountType.EVALUATION_AGENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        initUI()
    }

    private fun initUI() {
        val instruction =
            "By clicking <b><font color='#0C274C'>Submit</font></b>, you agree to our<br><b><font color='#0C274C'>Privacy Policy</font></b> and <b><font color='#0C274C'>Terms of Use</font></b>"
        instructionsText.text = HtmlCompat.fromHtml(instruction, HtmlCompat.FROM_HTML_MODE_LEGACY)

        accountType = intent.extras!!.getSerializable(ACCOUNT_TYPE) as AccountType
        submitButton.setOnClickListener {
            checkAccountCreation()
        }
        btnBack.setOnClickListener { onBackPressed() }
    }

    private fun checkAccountCreation() {
        if (nameEditText.empty() || ((nameEditText.text.toString().trim().split(" ")).size < 2)) {
            snackbarErrorCustom("Error!", "Please enter first name and last name")
        } else if (!usernameEditText.validEmail() && !usernameEditText.validPhone()) {
            snackbarErrorCustom("Error!", "Please enter a valid email address or phone number")
        } else if (passwordEditText.empty() || (passwordEditText.text.toString().length < 8)) {
            snackbarErrorCustom("Error!", "Please enter a password minimum of 8 characters")
        } else {
            NewsAnchorDefaults.appUserName= nameEditText.text.toString().trim()
            NewsAnchorDefaults.appPassword= passwordEditText.text.toString().trim()
            NewsAnchorDefaults.appEmail= usernameEditText.text.toString().trim()

            val intent = Intent(this, NewsAnchorLoginActivity::class.java)
            startActivityForResult(intent, SETTING_UP_REGISTER_REQUEST_CODE)
            overridePendingTransition(R.anim.slide_bottomlayer_display, R.anim.keep_active)
            snackbarBlueWithExitAction("Successfully account created..!", "Successfully account created..!", "Ok", this)
        }
    }

    private fun nameSpliter(isFirstName: Boolean): String {
        var names = nameEditText.text.toString().trim().split(" ")
        if (names.isNotEmpty()) {
            return if (isFirstName) {
                names[0]
            } else {
                var data = ""
                names.subList(1, names.size).forEach {
                    if (data == ""){
                        data = it
                    } else {
                        data = "$data $it"
                    }
                }

                data
            }
        }
        return ""
    }

}
