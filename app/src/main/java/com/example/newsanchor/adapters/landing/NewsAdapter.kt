package com.example.newsanchor.adapters.landing

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsanchor.R
import com.example.newsanchor.activities.NewsDetailsActivity
import com.example.newsanchor.helpers.Const.Companion.NEWS_ARTICLE_MODEL
import com.example.newsanchor.services.api.responsemodels.ArticlesResponse
import com.squareup.picasso.Picasso

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class NewsAdapter(private var context: Context, private var items: List<ArticlesResponse>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(
                context
            ).inflate(R.layout.widget_news, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if(!item.urlToImage.isNullOrEmpty())
        Picasso.get().load(item.urlToImage).into(holder.image)
        else
            Picasso.get().load(R.drawable.defult_image).into(holder.image)
        if(!item.title.isNullOrEmpty())
        holder.title.text = item.title.trim()
        if(!item.description .isNullOrEmpty())
        holder.des.text = item.description.trim()
        if(!item.publishedAt.isNullOrEmpty())
        holder.publishAt.text = item.publishedAt.trim()

        holder.layWalletBack.setOnClickListener {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(NEWS_ARTICLE_MODEL, item)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var layWalletBack: CardView = itemView!!.findViewById(R.id.layWalletMain)
        var image: ImageView = itemView!!.findViewById(R.id.imageIcon)
        var title: TextView = itemView!!.findViewById(R.id.title)
        var des : TextView = itemView!!.findViewById(R.id.descriptiom)
        var publishAt : TextView = itemView!!.findViewById(R.id.publish_at)
    }
}