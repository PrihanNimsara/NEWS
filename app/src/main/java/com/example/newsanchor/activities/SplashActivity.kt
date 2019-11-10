package com.example.newsanchor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsanchor.R
import com.example.newsanchor.activities.login.CreateOrLoginActivity
import com.example.newsanchor.activities.login.OnboardingActivity
import com.example.newsanchor.database.sharedpref.NewsAnchorDefaults

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this, CreateOrLoginActivity::class.java))

        if(NewsAnchorDefaults.isUserLogged){
            if (NewsAnchorDefaults.isInitialRun){
                startActivity(Intent(this, OnboardingActivity::class.java))
            } else {
                startActivity(Intent(this, LandingActivity::class.java))
            }
        }else{
            startActivity(Intent(this, CreateOrLoginActivity::class.java))
        }

        finish()
    }
}
