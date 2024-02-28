package com.helloalfred.view.ui.app_intro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.helloalfred.R
import com.example.helloalfred.databinding.ActivityAppIntroBinding
import com.helloalfred.utils.IntentUtils.IntentUtils
import com.helloalfred.utils.fullwindow.StatusBarUtil
import com.helloalfred.view.ui.account_type.AccountTypeActivity

class AppIntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //full screen method..
        StatusBarUtil.setTransparentStatusBar(window)

        binding.nextImageView.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AppIntroSecondActivity>(this)
        }
        binding.skipNavigate.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AccountTypeActivity>(this)
        }
    }
}