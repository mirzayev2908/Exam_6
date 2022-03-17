package com.example.exam_6

import android.util.Log

object Logger {
    fun d(tag: String?, msg: String?) {
        if (ApiClient.IS_TESTER) Log.d(tag, msg!!)
    }

    fun i(tag: String?, msg: String?) {
        if (ApiClient.IS_TESTER) Log.i(tag, msg!!)
    }

    fun v(tag: String?, msg: String?) {
        if (ApiClient.IS_TESTER) Log.v(tag, msg!!)
    }

    fun e(tag: String?, msg: String?) {
        if (ApiClient.IS_TESTER) Log.e(tag, msg!!)
    }
}