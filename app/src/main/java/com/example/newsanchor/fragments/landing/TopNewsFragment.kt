package com.example.newsanchor.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsanchor.R
import com.example.newsanchor.generateWallet
import com.example.newsanchor.invisible
import kotlinx.android.synthetic.main.fragment_wallet.*

/**
 * Created by K.I Prihan Nimsara on 2019-11-06.
 */
class WalletFragment : Fragment() {

    var isInitial: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wallet, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        walletMessage?.invisible()
        walletSwipeRefresh?.isRefreshing = true

//        val mHandler = Handler()
//        if (isInitial) {
//            val mRunnable = Runnable {
//                loadWallets()
//            }
//            mHandler.postDelayed(mRunnable, 800)
//        } else {
//            loadWallets()
//        }
//        isInitial = false

        loadWallets()
        walletSwipeRefresh?.setOnRefreshListener {
            loadWallets()
        }
    }

    private fun loadWallets() {
        if (walletSwipeRefresh != null && walletMessage != null && walletRecyclerView != null) {
            walletSwipeRefresh?.isRefreshing = false
            walletMessage?.invisible()
            walletRecyclerView?.apply {
                layoutManager = GridLayoutManager(activity, 2)
//                adapter = WalletAdapter(
//                    this.context,
//                    generateWallet()
//                )
            }
        }
    }

    companion object {
        fun newInstance(): WalletFragment =
            WalletFragment()
    }
}