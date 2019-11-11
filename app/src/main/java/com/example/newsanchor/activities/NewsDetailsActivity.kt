package com.example.newsanchor.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsanchor.R
import com.example.newsanchor.helpers.Const.Companion.NEWS_ARTICLE_MODEL
import com.example.newsanchor.services.api.responsemodels.ArticlesResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {

    private var articles: ArticlesResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        findNewsDeatilsObject()
        initUI()
    }

    private fun initUI() {
        btnBack.setOnClickListener { onBackPressed() }


        if (!articles?.urlToImage.isNullOrEmpty())
            Picasso.get().load(articles!!.urlToImage).into(imgage_view)
        else
            Picasso.get().load(resources.getResourceName(R.drawable.defult_image)).into(imgage_view)

        if (!articles?.title.isNullOrEmpty())
            text_view_title.text = articles!!.title.trim()
        else
            text_view_title.text = "N/A"

        if (!articles?.author.isNullOrEmpty())
            text_view_Autor.text = articles!!.author.trim()
        else
            text_view_Autor.text = "N/A"

        if (!articles?.publishedAt.isNullOrEmpty())
            text_view_publishat.text = articles!!.publishedAt.trim()
        else
            text_view_publishat.text = "N/A"

        if (!articles?.description.isNullOrEmpty())
            text_view_description.text = articles!!.description.trim()
        else
            text_view_description.text = "N/A"

        if (!articles?.content.isNullOrEmpty())
            text_view_content.text = articles!!.content.trim()
        else
            text_view_content.text = "N/A"


        if (!articles?.url.isNullOrEmpty())
            text_view_url.text = articles!!.url.trim()
        else
            text_view_url.text = "N/A"
    }

    private fun findNewsDeatilsObject() {
        articles = intent.getSerializableExtra(NEWS_ARTICLE_MODEL) as? ArticlesResponse
    }
}
