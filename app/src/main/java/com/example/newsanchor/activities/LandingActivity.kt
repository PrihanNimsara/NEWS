package com.example.newsanchor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.newsanchor.BottomNavigationHelper
import com.example.newsanchor.R
import com.example.newsanchor.activities.helpers.LogoutConfirmationActivity
import com.example.newsanchor.activities.login.CreateOrLoginActivity
import com.example.newsanchor.adapters.NewsAnchorPagerAdapter
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults
import com.example.newsanchor.fragments.landing.*
import com.example.newsanchor.gone
import com.example.newsanchor.helpers.Const.Companion.LOGOUT_CODE
import com.example.newsanchor.helpers.ui.BottomMenuHelper
import com.example.newsanchor.services.api.responsemodels.NewsResponse
import com.example.newsanchor.services.sync.TopHeadLineSync
import com.example.newsanchor.visible
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.toolbar_main_with_noti_icon.*

class LandingActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce: Boolean = false
    var isInitial: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        initUI()
    }

    private fun initUI() {
        BottomNavigationHelper.removeShiftMode(bottomNavigation)
        setUpViewPager()

        toolbarTitle.text = getString(R.string.titleTasks)

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        bottomNavigationContainer.currentItem = 1

        BottomMenuHelper.showBadge(this, bottomNavigation, R.id.navigationTopHeadlineNews, "1")

        bottomNavigation.setOnNavigationItemReselectedListener {
            return@setOnNavigationItemReselectedListener
        }

        profileLogoutIcon.setOnClickListener {
            startActivityForResult(Intent(this, LogoutConfirmationActivity::class.java), LOGOUT_CODE)
        }
    }

    private fun setUpViewPager(){
        val adapter = NewsAnchorPagerAdapter(this.supportFragmentManager)
        adapter.addFrag(TopNewsFragment.newInstance(), "Top News")
        adapter.addFrag(CustomNewsFragment.newInstance(), "Custom News")
        adapter.addFrag(InboxFragment.newInstance(), "Profile")

        bottomNavigationContainer.adapter = adapter

        bottomNavigationContainer.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {}

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        bottomNavigation.selectedItemId = R.id.navigationTopHeadlineNews
                    }
                    1 -> {
                        bottomNavigation.selectedItemId = R.id.navigationCustomNews
                    }
                    2 -> {
                        bottomNavigation.selectedItemId = R.id.navigationProfile
                    }
                }
            }
        })
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        if (item.itemId == R.id.navigationProfile){
            profileEditIcon?.visible()
            profileLogoutIcon?.visible()
        } else {
            profileEditIcon?.gone()
            profileLogoutIcon?.gone()
        }

        when (item.itemId) {
            R.id.navigationTopHeadlineNews -> {
                toolbarTitle.text = getString(R.string.title_top_news)
                BottomMenuHelper.removeBadge(bottomNavigation, R.id.navigationTopHeadlineNews)
                bottomNavigationContainer.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationCustomNews -> {
                toolbarTitle.text = getString(R.string.title_custom_news)
                bottomNavigationContainer.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigationProfile -> {
                toolbarTitle.text = getString(R.string.title_profile)
                bottomNavigationContainer.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finish()
        }

        doubleBackToExitPressedOnce = true
        val toast = Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT)
        toast.show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    override fun onResume() {
        super.onResume()
        if (NewsAnchorDefaults.isInitialRun) {
            NewsAnchorDefaults.isInitialRun = false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==  LOGOUT_CODE && resultCode == LOGOUT_CODE){
            startActivity(Intent(this,CreateOrLoginActivity::class.java))
            finish()
        }
    }


}
