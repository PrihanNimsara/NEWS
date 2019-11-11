package com.example.newsanchor.activities.login

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_LOGIN_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SUCCESSFUL_CREATE_ACCOUNT_CODE
import com.example.newsanchor.helpers.enums.AccountType
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_select_account_type.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class SelectAccountTypeActivity : AppCompatActivity() {


    private var titleList: List<TextView>? = null
    private var tickList: List<CircleImageView>? = null
    private var backgroundList: List<RelativeLayout>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_account_type)

        initUI()
    }
    private fun initUI() {
        titleList = listOf(tv_bitcoin,tv_apple,tv_earthquake,tv_animal)
        tickList = listOf(tick_bitcoin, tick_apple, tick_earthquake,tick_animal)
        backgroundList = listOf(lay_one, lay_two, lay_three,lay_four)

        val haveAccoutText = "Already have an account? <b>Log in</b>"
        instructionsText.text =
            HtmlCompat.fromHtml(haveAccoutText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        lay_one.setOnClickListener {
            NewsAnchorDefaults.preferedNewsType = 1


            changeColors(tv_bitcoin, tick_bitcoin, lay_one)
        }
        lay_two.setOnClickListener {
            NewsAnchorDefaults.preferedNewsType = 2


            changeColors(tv_apple, tick_apple,lay_two)
        }
        lay_three.setOnClickListener {
            NewsAnchorDefaults.preferedNewsType = 3


            changeColors(tv_earthquake,tick_earthquake,lay_three)
        }
        lay_four.setOnClickListener {
            NewsAnchorDefaults.preferedNewsType = 4


            changeColors(tv_animal,tick_animal,lay_four)
        }


        submitButton.setOnClickListener {
            startActivity(Intent(this, CreateAccountActivity::class.java))
        }

        instructionsText.setOnClickListener {
            val intent = Intent(this, NewsAnchorLoginActivity::class.java)
            startActivityForResult(intent,SETTING_UP_LOGIN_REQUEST_CODE)
        }

        lay_one.performClick()

        btnBack.setOnClickListener { onBackPressed() }
    }

    private fun changeColors(title: TextView,tick: CircleImageView, background: RelativeLayout) {
        titleList!!.forEach {
            if (it === title) {
                it.setTextColor(ContextCompat.getColor(this, R.color.pureWhite))
            } else {
                it.setTextColor(ContextCompat.getColor(this, R.color.colorTitle))
            }
        }



        tickList!!.forEach {
            if (it === tick) {
                it.background = getDrawable(R.drawable.vector_drawable_tick)
            } else {
                it.background = getDrawable(R.drawable.vector_drawable_tick_empty)
            }
        }

        backgroundList!!.forEach {
            if (it === background) {
                it.background =
                    ContextCompat.getDrawable(this, R.drawable.form_submit_button_dark_blue)
            } else {
                it.background =
                    ContextCompat.getDrawable(this, R.drawable.round_stroke_trans_wallet)
            }
        }
    }
}
