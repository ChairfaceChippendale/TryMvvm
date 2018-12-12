package com.ujujzk.mobile.ui

import android.support.annotation.StringRes
import com.ujujzk.mobile.model.Progress
import java.lang.RuntimeException

interface IView {
    fun progress(progress: Progress) {
        throw RuntimeException("Not implemented")
    }

    fun isNetworkConnected(): Boolean

    fun hideKeyboard()

    fun toast(message: String)

    fun toast(@StringRes resId: Int)
}