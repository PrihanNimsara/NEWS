package com.example.newsanchor.fragments.landing

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsanchor.R
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import kotlinx.android.synthetic.main.fragment_inbox.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_inbox, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        setupWithYourProgress()

        name.text= NewsAnchorDefaults.appUserName.trim()
        contact.text = NewsAnchorDefaults.appEmail.trim()
    }

    @SuppressLint("SetTextI18n")
    private fun setupWithYourProgress() {
}

    companion object {
        fun newInstance(): ProfileFragment =
            ProfileFragment()
    }
}