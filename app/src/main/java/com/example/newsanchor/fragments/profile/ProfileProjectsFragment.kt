package com.example.newsanchor.fragments.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.generateProjects
import com.example.newsanchor.invisible
import kotlinx.android.synthetic.main.fragment_profile_projects.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProfileProjectsFragment : Fragment() {

    var isInitial: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_projects, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        projectMessage?.invisible()
        projectSwipeRefresh?.isRefreshing = true

        loadProjects()

        projectSwipeRefresh?.setOnRefreshListener {
            loadProjects()
        }
    }

    private fun loadProjects() {
        if (projectSwipeRefresh != null && projectMessage != null && projectsRecyclerView != null) {
            projectSwipeRefresh?.isRefreshing = false
            projectMessage.invisible()

            projectsRecyclerView?.apply {
                layoutManager = LinearLayoutManager(activity)
//               // adapter = ProfileProjectsAdapter(
//                    this.context,
//                    generateProjects().subList(0, 4)
//                )
            }

            projectsRecyclerView.computeVerticalScrollRange()
        }
    }
    companion object {
        fun newInstance(): ProfileProjectsFragment =
            ProfileProjectsFragment()
    }
}