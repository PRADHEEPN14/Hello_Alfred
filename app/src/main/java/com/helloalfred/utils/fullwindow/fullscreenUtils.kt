package com.helloalfred.utils.fullwindow

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager


object StatusBarUtil {
    fun setTransparentStatusBar(window: Window) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(window, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(window, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(window: Window, bits: Int, on: Boolean) {
        val winParams = window.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        window.attributes = winParams
    }
}
