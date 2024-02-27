package com.helloalfred.utils.IntentUtils

import android.app.Activity
import android.content.Context
import android.content.Intent

class IntentUtils {

    companion object {
        inline fun <reified T : Any> redirectToNextAppIntro(context: Context) {
            val introActivity = Intent(context, T::class.java)
            introActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            introActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(introActivity)
            if (context is Activity) {
                context.finish()
            }
        }
    }
}
