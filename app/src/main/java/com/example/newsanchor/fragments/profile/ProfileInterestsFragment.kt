package com.example.newsanchor.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.generateUserInterests
import com.example.newsanchor.invisible
import kotlinx.android.synthetic.main.fragment_profile_interests.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProfileInterestsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_interests, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        interestsMessage?.invisible()
        interestsSwipeRefresh?.isRefreshing = true

        loadProjects()

        interestsSwipeRefresh?.setOnRefreshListener {
            loadProjects()
        }
    }

    private fun loadProjects() {
        if (interestsSwipeRefresh != null && interestsMessage != null && interestsRecyclerView != null) {
            interestsSwipeRefresh?.isRefreshing = false
            interestsMessage?.invisible()

            interestsRecyclerView?.apply {
                layoutManager = GridLayoutManager(activity, 3)
//                adapter = ProfileInterestsAdapter(
//                    this.context,
//                    generateUserInterests()
//                )
            }

            interestsRecyclerView.computeVerticalScrollRange()
        }
    }

    companion object {
        fun newInstance(): ProfileInterestsFragment =
            ProfileInterestsFragment()
    }
}