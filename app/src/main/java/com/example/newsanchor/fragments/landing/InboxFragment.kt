package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsanchor.R

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class InboxFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inbox, container, false)
        return view
    }

    companion object {
        fun newInstance(): InboxFragment =
            InboxFragment()
    }
}