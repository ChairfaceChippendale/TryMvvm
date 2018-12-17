package com.ujujzk.mobile.ui

import android.content.Context
import android.net.ConnectivityManager
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity(), IView {


    fun replaceFragment(fragment: Fragment, @IdRes containerId: Int) {
        val fragmentName = fragment.javaClass.simpleName
        if (supportFragmentManager.findFragmentByTag(fragmentName) == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(containerId, fragment, fragmentName)
                commit()
            }
        }
    }

    override fun isNetworkConnected(): Boolean {
        return (applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)?.activeNetworkInfo?.isConnected
                ?: false
    }

    override fun hideKeyboard() {
        currentFocus?.windowToken?.let {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(it, 0)
        }
    }

    override fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun toast(@StringRes resId: Int) {
        toast(getString(resId))
    }
}