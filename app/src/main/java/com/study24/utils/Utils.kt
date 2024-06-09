package com.study24.utils

import android.util.Log
import com.study24.BuildConfig

inline fun logD(tag: String, message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, message)
    }
}