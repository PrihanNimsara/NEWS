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
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.invisible
import com.example.newsanchor.services.api.responsemodels.ArticlesResponse
import com.example.newsanchor.services.api.responsemodels.NewsResponse
import com.example.newsanchor.services.sync.CustomNewsSync
import kotlinx.android.synthetic.main.fragment_custom_news.*
import kotlinx.android.synthetic.main.fragment_top_news.walletMessage
import kotlinx.android.synthetic.main.fragment_top_news.walletRecyclerView
import kotlinx.android.synthetic.main.fragment_top_news.walletSwipeRefresh

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class CustomNewsFragment : Fragment(), CustomNewsSync.CustomeNewsCallback {

    var newsType: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_custom_news, container, false)
        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        newsType = getNewsType(NewsAnchorDefaults.preferedNewsType)

        walletMessage?.invisible()
        walletSwipeRefresh?.isRefreshing = true

        callTheCustomeNewsApi(newsType!!)
        walletSwipeRefresh?.setOnRefreshListener {
            callTheCustomeNewsApi(newsType!!)
        }
        button_bitcoin.setOnClickListener {
            walletSwipeRefresh?.isRefreshing = true
            callTheCustomeNewsApi(getString(R.string.bitcoin))
            NewsAnchorDefaults.preferedNewsType = 1
        }
        button_apple.setOnClickListener {
            walletSwipeRefresh?.isRefreshing = true
            callTheCustomeNewsApi(getString(R.string.apple))
            NewsAnchorDefaults.preferedNewsType = 2
        }
        button_earth.setOnClickListener {
            walletSwipeRefresh?.isRefreshing = true
            callTheCustomeNewsApi(getString(R.string.earthquake))
            NewsAnchorDefaults.preferedNewsType = 3
        }
        button_animal.setOnClickListener {
            walletSwipeRefresh?.isRefreshing = true
            callTheCustomeNewsApi(getString(R.string.animal))
            NewsAnchorDefaults.preferedNewsType = 4
        }
    }

    private fun loadWallets(articles: List<ArticlesResponse>) {
        if (walletSwipeRefresh != null && walletMessage != null && walletRecyclerView != null) {
            walletSwipeRefresh?.isRefreshing = false
            walletMessage?.invisible()
            walletRecyclerView?.apply {
                layoutManager = GridLayoutManager(activity, 2)
                adapter = NewsAdapter(
                    this.context, articles
                )
            }
        }
    }

    companion object {
        fun newInstance(): CustomNewsFragment =
            CustomNewsFragment()
    }

    override fun onCustomeNewsFound(status: Boolean, response: NewsResponse?, message: String) {
        if(status)
        loadWallets(response!!.articles)
        else
            showError()
    }

    fun callTheCustomeNewsApi(searchType: String) {
        CustomNewsSync(this, searchType).list()
    }

    fun getNewsType(value: Int): String {
        when (value) {
            1 -> return getString(R.string.bitcoin)
            2 -> return getString(R.string.apple)
            3 -> return getString(R.string.earthquake)
            else -> return getString(R.string.animal)
        }
    }
    private fun showError(){
        walletSwipeRefresh?.isRefreshing = false
        Toast.makeText(context,"please check internet connection",Toast.LENGTH_SHORT).show()
    }
}