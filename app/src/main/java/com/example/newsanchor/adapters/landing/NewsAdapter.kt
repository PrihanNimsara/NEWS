package com.example.newsanchor.adapters.landing

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
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
import com.example.newsanchor.services.api.responsemodels.NewsResponse
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
        Picasso.get().load(item.urlToImage).into(holder.image)
        holder.author.setText(item.author)
        holder.title.setText(item.title)

        holder.layWalletBack.setOnClickListener {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(NEWS_ARTICLE_MODEL, item)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var layWalletBack: CardView = itemView!!.findViewById(R.id.layWalletMain)
        var image: ImageView = itemView!!.findViewById(R.id.imageIcon)
        var author: TextView = itemView!!.findViewById(R.id.autor)
        var title: TextView = itemView!!.findViewById(R.id.title)
    }
}