package com.helloalfred.utils

import android.content.Context
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class ActivityBase : AppCompatActivity() {

//    private fun setupOtpEditText(currentEditText: EditText, previousEditText: EditText?, nextEditText: EditText?) {
//        currentEditText.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(
//                charSequence: CharSequence,
//                start: Int,
//                before: Int,
//                count: Int
//            ) {
//                // Not used in this example
//            }
//
//            override fun onTextChanged(
//                charSequence: CharSequence,
//                start: Int,
//                before: Int,
//                count: Int
//            ) {
//                if (count > 0 && nextEditText != null) {
//                    Handler().post {
//                        nextEditText.requestFocus()
//                        Toast.makeText(this@ActivityBase, "onTextChanged", Toast.LENGTH_SHORT).show()
//                    }
//                } else if (count == 0 && previousEditText != null) {
//                    // If the current field is cleared, move the cursor back to the previous field
//                    Handler().post {
//                        previousEditText.requestFocus()
//                    }
//                } else {
//                    // Check if all fields are filled, if so, close the keyboard
//                    if (currentEditText.text.isNotEmpty() && isAllFieldsFilled()) {
//                        otpText=binding.etOtp1.text.toString()+ binding.etOtp2.text.toString()+
//                                binding.etOtp3.text.toString()+ binding.etOtp4.text.toString();
//                        Toast.makeText(this@ActivityBase, otpText.toString(), Toast.LENGTH_SHORT).show()
//                        closeKeyboard()
//                    }
//                }
//            }
//
//            override fun afterTextChanged(editable: Editable) {
//                Toast.makeText(this@ActivityBase, editable.toString(), Toast.LENGTH_SHORT).show()
//            }
//        })
//    }



    // Function to close the keyboard
    fun closeKeyboard() {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}