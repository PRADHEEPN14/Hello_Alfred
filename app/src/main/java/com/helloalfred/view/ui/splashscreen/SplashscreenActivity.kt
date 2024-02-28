package com.helloalfred.view.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.helloalfred.R
import com.helloalfred.utils.fullwindow.StatusBarUtil
import com.helloalfred.view.ui.app_intro.AppIntroActivity

class SplashscreenActivity : AppCompatActivity() {
    private lateinit var mHandler: Handler
    private lateinit var runnable: Runnable
    private val screenTimeOut = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        redirectAppIntro()
        //full screen method..
        StatusBarUtil.setTransparentStatusBar(window)
    }
   private fun redirectAppIntro(){
       runnable= Runnable {
           val introActivity=Intent(this, AppIntroActivity::class.java)
           introActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
           introActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
           startActivity(introActivity)
           finish()
       }
       mHandler = Handler(Looper.getMainLooper())
       mHandler.postDelayed(runnable, screenTimeOut)
   }
}