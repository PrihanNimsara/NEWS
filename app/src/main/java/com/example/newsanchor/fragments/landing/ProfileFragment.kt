package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsanchor.R
import com.example.newsanchor.adapters.NewsAnchorPagerAdapter
import com.example.newsanchor.fragments.profile.ProfileInterestsFragment
import com.example.newsanchor.fragments.profile.ProfileProjectsFragment
import com.example.newsanchor.services.sync.TopHeadLineSync
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val projectsFragment: ProfileProjectsFragment = ProfileProjectsFragment.newInstance()
        val interestsFragment: ProfileInterestsFragment = ProfileInterestsFragment.newInstance()

        val adapter = NewsAnchorPagerAdapter(childFragmentManager)
        adapter.addFrag(projectsFragment, "Projects")
        adapter.addFrag(interestsFragment, "Interests")

        viewPagerProfile!!.adapter = adapter
        tabLayoutProfile.setupWithViewPager(viewPagerProfile)
    }

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }


}