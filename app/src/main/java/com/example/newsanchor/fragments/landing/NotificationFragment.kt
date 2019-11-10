package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.generateNotifications
import com.example.newsanchor.invisible
import com.example.newsanchor.services.api.responsemodels.NewsResponse
import com.example.newsanchor.services.sync.TopHeadLineSync
import kotlinx.android.synthetic.main.fragment_notification.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class NotificationFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        notificationMessage?.invisible()
        notificationSwipeRefresh?.isRefreshing = true

        loadNotifications()
        notificationSwipeRefresh?.setOnRefreshListener {
            loadNotifications()
        }
    }

    private fun loadNotifications() {
        if (notificationSwipeRefresh != null && notificationMessage != null && notificationRecyclerView != null) {
            notificationSwipeRefresh?.isRefreshing = false
            notificationMessage?.invisible()
            notificationRecyclerView?.apply {
                layoutManager = LinearLayoutManager(activity)
//                adapter = NotificationAdapter(
//                    this.context,
//                    generateNotifications()
//                )
            }
        }
    }

    companion object {
        fun newInstance(): NotificationFragment =
            NotificationFragment()
    }


}