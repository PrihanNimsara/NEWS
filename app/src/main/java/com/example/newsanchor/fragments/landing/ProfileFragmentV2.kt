package com.example.newsanchor.fragments.landing

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsanchor.R
import com.example.newsanchor.generateYourTasks
import com.example.newsanchor.helpers.enums.YourTaskType
import kotlinx.android.synthetic.main.container_your_task_completion.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProfileFragmentV2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile_v2, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        setupWithYourProgress()
    }

    @SuppressLint("SetTextI18n")
    private fun setupWithYourProgress(){
        val completedTasks = generateYourTasks(YourTaskType.COMPLETED)
        val pendingTasks = generateYourTasks(YourTaskType.TODO)

        val totalTasks = completedTasks.size + pendingTasks.size

        txtOutOfValue.text = "${completedTasks.size}/${totalTasks}"
        progressOfYourTasks.max = totalTasks
        progressOfYourTasks.progress = completedTasks.size

        txtStartValue.text = "0"
        txtMidValue.text = "Half way"
        txtEndValue.text = "${totalTasks}"
    }

    companion object {
        fun newInstance(): ProfileFragmentV2 =
            ProfileFragmentV2()
    }
}