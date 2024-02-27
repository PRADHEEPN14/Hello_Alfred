package com.helloalfred.view.ui.app_intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloalfred.databinding.ActivityAppIntroSecondBinding
import com.helloalfred.utils.IntentUtils.IntentUtils
import com.helloalfred.view.ui.account_type.AccountTypeActivity

class AppIntroSecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppIntroSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAppIntroSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextImageView.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AppIntroThirdActivity>(this)
        }
        binding.skipNavigate.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AccountTypeActivity>(this)
        }
    }
}