package com.ujujzk.mobile.core.extension

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun <T:ViewDataBinding> ViewGroup.inflate(@LayoutRes layoutRes: Int): T =
        DataBindingUtil.inflate<T>(LayoutInflater.from(context), layoutRes, this, false)

