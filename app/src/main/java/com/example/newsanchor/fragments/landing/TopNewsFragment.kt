package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.adapters.landing.NewsAdapter
import com.example.newsanchor.invisible
import com.example.newsanchor.services.api.responsemodels.ArticlesResponse
import com.example.newsanchor.services.api.responsemodels.NewsResponse
import com.example.newsanchor.services.sync.TopHeadLineSync
import kotlinx.android.synthetic.main.fragment_top_news.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class TopNewsFragment : Fragment(),TopHeadLineSync.TopHeadLineCallback{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top_news, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        walletMessage?.invisible()
        walletSwipeRefresh?.isRefreshing = true
        callThetopNewsApi()
        walletSwipeRefresh?.setOnRefreshListener {
            callThetopNewsApi()
        }
    }

    private fun loadWallets(articles : List<ArticlesResponse>) {
        if (walletSwipeRefresh != null && walletMessage != null && walletRecyclerView != null) {
            walletSwipeRefresh?.isRefreshing = false
            walletMessage?.invisible()
            walletRecyclerView?.apply {
                layoutManager = GridLayoutManager(activity, 2)
                adapter = NewsAdapter(
                    this.context,articles
               )
            }
        }
    }

    companion object {
        fun newInstance(): TopNewsFragment =
            TopNewsFragment()
    }

    override fun onTopHeadLinesFound(status: Boolean, response: NewsResponse?, message: String) {
        if(status)
        loadWallets(response!!.articles)
        else
            showError()
    }

    fun callThetopNewsApi(){
        TopHeadLineSync(this).list()
    }
    private fun showError(){
        walletSwipeRefresh?.isRefreshing = false
        Toast.makeText(context,"please check internet connection", Toast.LENGTH_SHORT).show()
    }
}