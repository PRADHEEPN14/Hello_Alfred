package com.helloalfred.view.ui.account_type

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloalfred.R
import com.example.helloalfred.databinding.ActivityAccountTypeBinding
import com.example.helloalfred.databinding.ActivityAppIntroThirdBinding
import com.helloalfred.utils.IntentUtils.IntentUtils
import com.helloalfred.utils.fullwindow.StatusBarUtil
import com.helloalfred.view.ui.otpscreen.OTPActivity

class AccountTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountTypeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAccountTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //full screen method..
        StatusBarUtil.setTransparentStatusBar(window)
        binding.firstImageView.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<OTPActivity>(this)
        }
    }
}