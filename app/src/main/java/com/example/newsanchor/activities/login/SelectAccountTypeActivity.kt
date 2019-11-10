package com.example.newsanchor.activities.login

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.example.newsanchor.R
import com.example.newsanchor.helpers.Const
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE
import com.example.newsanchor.helpers.Const.Companion.ACCOUNT_TYPE_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SETTING_UP_LOGIN_REQUEST_CODE
import com.example.newsanchor.helpers.Const.Companion.SUCCESSFUL_CREATE_ACCOUNT_CODE
import com.example.newsanchor.helpers.enums.AccountType

import com.example.newsanchor.load
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_select_account_type.*


class SelectAccountTypeActivity : AppCompatActivity() {
    var selectedType: AccountType = AccountType.FUNDER

    private var titleList: List<TextView>? = null
    private var descriptionList: List<TextView>? = null
    private var tickList: List<CircleImageView>? = null
    private var backgroundList: List<RelativeLayout>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_account_type)

        initUI()
    }
    private fun initUI() {
        titleList = listOf(tvFunder, tvEvaluator, tvContractor)
        descriptionList = listOf(tvFunderDescription, tvEvaluatorDescription, tvContractorDescription)
        tickList = listOf(tickContractor, tickEvaluator, tickFunder)
        backgroundList = listOf(layBtnFunder, layBtnContractor, layBtnEvalutation)

        val haveAccoutText = "Already have an account? <b>Log in</b>"
        instructionsText.text =
            HtmlCompat.fromHtml(haveAccoutText, HtmlCompat.FROM_HTML_MODE_LEGACY)

        layBtnFunder.setOnClickListener {
            selectedType = AccountType.FUNDER
            changeColors(tvFunder, tvFunderDescription, tickFunder, layBtnFunder)
        }
        layBtnContractor.setOnClickListener {
            selectedType = AccountType.CONTRACTOR
            changeColors(tvContractor, tvContractorDescription, tickContractor, layBtnContractor)
        }
        layBtnEvalutation.setOnClickListener {
            selectedType = AccountType.EVALUATION_AGENT
            changeColors(tvEvaluator, tvEvaluatorDescription, tickEvaluator, layBtnEvalutation)
        }

        submitButton.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            intent.putExtra(ACCOUNT_TYPE, selectedType)

            startActivityForResult(intent, ACCOUNT_TYPE_REQUEST_CODE)
        }

        instructionsText.setOnClickListener {
            val intent = Intent(this, NewsAnchorLoginActivity::class.java)
            startActivityForResult(intent, Const.SETTING_UP_LOGIN_REQUEST_CODE)
        }


        layBtnFunder.performClick()
    }

    private fun changeColors(title: TextView, description: TextView, tick: CircleImageView, background: RelativeLayout) {
        titleList!!.forEach {
            if (it === title) {
                it.setTextColor(ContextCompat.getColor(this, R.color.pureWhite))
            } else {
                it.setTextColor(ContextCompat.getColor(this, R.color.colorTitle))
            }
        }

        descriptionList!!.forEach {
            if (it === description) {
                it.setTextColor(ContextCompat.getColor(this, R.color.pureWhite))
            } else {
                it.setTextColor(ContextCompat.getColor(this, R.color.colorTitle))
            }
        }

        tickList!!.forEach {
            if (it === tick) {
                ContextCompat.getDrawable(this, R.drawable.vector_drawable_tick)?.let { it1 ->
                    it.load(
                        it1, R.drawable.vector_drawable_tick_empty
                    )
                }
            } else {
                ContextCompat.getDrawable(this, R.drawable.vector_drawable_tick_empty)?.let { it1 ->
                    it.load(
                        it1, R.drawable.vector_drawable_tick_empty
                    )
                }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACCOUNT_TYPE_REQUEST_CODE && resultCode == ACCOUNT_TYPE_REQUEST_CODE) {
            setResult(ACCOUNT_TYPE_REQUEST_CODE)
            finish()
        } else if (resultCode == SETTING_UP_LOGIN_REQUEST_CODE && requestCode == SETTING_UP_LOGIN_REQUEST_CODE){
            setResult(ACCOUNT_TYPE_REQUEST_CODE)
            finish()
        } else if (requestCode == ACCOUNT_TYPE_REQUEST_CODE && resultCode == SUCCESSFUL_CREATE_ACCOUNT_CODE){
            finish()
        }
    }
}
