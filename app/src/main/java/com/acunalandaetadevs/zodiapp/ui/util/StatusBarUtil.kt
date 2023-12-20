package com.acunalandaetadevs.zodiapp.ui.util

import android.app.Activity
import android.graphics.Color
import android.os.Build

object StatusBarUtil {

    fun setTransparentStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.statusBarColor = Color.TRANSPARENT
        }
    }
}