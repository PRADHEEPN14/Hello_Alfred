package com.helloalfred.view.ui.app_intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.helloalfred.R
import com.example.helloalfred.databinding.ActivityAppIntroThirdBinding
import com.helloalfred.utils.IntentUtils.IntentUtils
import com.helloalfred.view.ui.account_type.AccountTypeActivity

class AppIntroThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppIntroThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAppIntroThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextImageView.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AccountTypeActivity>(this)
        }
        binding.skipNavigate.setOnClickListener {
            IntentUtils.redirectToNextAppIntro<AccountTypeActivity>(this)
        }
    }

}
