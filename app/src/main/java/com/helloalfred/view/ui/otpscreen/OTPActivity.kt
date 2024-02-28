package com.helloalfred.view.ui.otpscreen

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.EditText
import android.widget.Toast
import com.example.helloalfred.R
import com.example.helloalfred.databinding.ActivityOtpactivityBinding
import com.helloalfred.utils.ActivityBase


class OTPActivity : ActivityBase() {
    var otpText=""
    private lateinit var binding: ActivityOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Get the user's mobile number from the intent
        val userMobileNumber ="1234567890"
//            intent.getStringExtra("userMobileNumber")
        val lastFourDigits = userMobileNumber?.takeLast(4)
        binding.tvHeading1.text="Enter otp sent to ******$lastFourDigits"
        //OTP auto move to next box function
        setupOtpEditText(binding.etOtp1,null, binding.etOtp2);
        setupOtpEditText(binding.etOtp2,binding.etOtp1, binding.etOtp3);
        setupOtpEditText(binding.etOtp3,binding.etOtp2, binding.etOtp4);
        setupOtpEditText(binding.etOtp4, binding.etOtp3,null);
    }

    private fun setupOtpEditText(currentEditText: EditText, previousEditText: EditText?, nextEditText: EditText?) {
        currentEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                // Not used in this example
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (count > 0 && nextEditText != null) {
                    Handler().post {
                        nextEditText.requestFocus()
                        currentEditText.setBackgroundResource(R.drawable.otpbox_shadow)
                        Toast.makeText(this@OTPActivity, "onTextChanged", Toast.LENGTH_SHORT).show()
                    }
                } else if (count == 0 && previousEditText != null) {
                    // If the current field is cleared, move the cursor back to the previous field
                    Handler().post {
                            previousEditText.requestFocus()
                        currentEditText.setBackgroundResource(R.drawable.otpbox_bg)

                    }
                }
                else if (charSequence.isEmpty() && previousEditText != null) {
                    // If the user clears a box with less than 2 characters, move back to the previous box
                    Handler().post {
                        previousEditText.requestFocus()
                    }
                }else {
                    // Check if all fields are filled, if so, close the keyboard
                    if (currentEditText.text.isNotEmpty() && isAllFieldsFilled()) {
                        otpText=binding.etOtp1.text.toString()+ binding.etOtp2.text.toString()+
                                binding.etOtp3.text.toString()+ binding.etOtp4.text.toString();
                        Toast.makeText(this@OTPActivity, otpText.toString(), Toast.LENGTH_SHORT).show()
                        // close the keyBoard after enter Otp
                        closeKeyboard()
                    }
                }
            }

            override fun afterTextChanged(editable: Editable) {
                Toast.makeText(this@OTPActivity, editable.toString(), Toast.LENGTH_SHORT).show()
            }

        })
        currentEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                currentEditText.setBackgroundResource(R.drawable.otpbox_shadow)
            } else {
                currentEditText.setBackgroundResource(R.drawable.otpbox_bg)
            }
        }
        currentEditText.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL && event.action == KeyEvent.ACTION_DOWN && currentEditText.text.isEmpty() && previousEditText != null) {
                // Handle back button press when the current field is empty
                previousEditText.requestFocus()
                true
            } else {
                false
            }
        }
    }


    // Function to check if all fields are filled
    private fun isAllFieldsFilled(): Boolean {
        return binding.etOtp1.text.isNotEmpty() && binding.etOtp2.text.isNotEmpty() &&
                binding.etOtp3.text.isNotEmpty() && binding.etOtp4.text.isNotEmpty()
    }


}