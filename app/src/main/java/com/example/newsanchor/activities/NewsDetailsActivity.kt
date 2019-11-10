package com.example.newsanchor.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsanchor.R
import com.example.newsanchor.helpers.Const.Companion.NEWS_ARTICLE_MODEL
import com.example.newsanchor.services.api.responsemodels.ArticlesResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {
    var articles: ArticlesResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        findWalletObject()
        initUI()
    }

    private fun initUI() {
        btnBack.setOnClickListener { onBackPressed() }
        description.text=articles!!.content
        url.text= articles!!.url
        headline.text=articles!!.title
        date.text=articles!!.publishedAt
        Picasso.get().load(articles!!.urlToImage).into(image)
        newsSourse.text = articles!!.source.name
    }

    private fun findWalletObject() {
        articles = intent.getSerializableExtra(NEWS_ARTICLE_MODEL) as? ArticlesResponse
    }
}
