package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.invisible
import com.example.newsanchor.models.ProjectModel
import com.example.newsanchor.visible
import kotlinx.android.synthetic.main.fragment_profile_projects.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProjectFragment  : Fragment(){

    var isInitial: Boolean = true
    var projectList: List<ProjectModel> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_project, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        syncProjects()

        projectSwipeRefresh.setOnRefreshListener {
            syncProjects()
        }
    }

    private fun syncProjects(){
        projectMessage?.invisible()
        projectSwipeRefresh?.isRefreshing = true
        //ProjectSync(this).list()
    }

    private fun loadProjects() {
        if (projectSwipeRefresh != null && projectMessage != null && projectsRecyclerView != null) {
            projectMessage?.invisible()

            projectsRecyclerView?.apply {
                layoutManager = LinearLayoutManager(activity)
//                adapter = ProjectsAdapter(
//                    this.context,
//                    projectList
//                )
            }

            projectsRecyclerView.computeVerticalScrollRange()
        }
    }

//    override fun onProjectsFound(status: Boolean, response: List<ProjectModel>?, message: String) {
//        projectSwipeRefresh?.isRefreshing = false
//        if (status){
//            if (response != null && response.isNotEmpty()){
//                projectList = response
//                loadProjects()
//            } else {
//                projectMessage?.text = message
//                projectMessage?.visible()
//            }
//        } else {
//            projectMessage?.text = message
//            projectMessage?.visible()
//        }
//    }

    companion object {
        fun newInstance(): ProjectFragment = ProjectFragment()
    }
}