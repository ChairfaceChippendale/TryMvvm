package com.ujujzk.mobile.ui

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import com.ujujzk.mobile.CatsApplication
import com.ujujzk.mobile.injection.di.ApplicationComponent
import com.ujujzk.mobile.model.Progress
import javax.inject.Inject

abstract class BaseFragment : Fragment(), IView{

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var baseActivity: BaseActivity? = null


    val appComponent: ApplicationComponent by lazy (mode = LazyThreadSafetyMode.NONE){
        (activity?.application as CatsApplication).appComponent
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity){
            baseActivity = context
        }
    }

    override fun progress(progress: Progress) {
        if  (isAdded){
            hideKeyboard()
            baseActivity?.progress(progress)
        }
    }

    override fun isNetworkConnected(): Boolean = baseActivity?.isNetworkConnected() ?: false


    override fun hideKeyboard() {
        baseActivity?.hideKeyboard()
    }

    override fun toast(message: String) {
        baseActivity?.toast(message)
    }

    override fun toast(@StringRes resId: Int) {
        baseActivity?.toast(resId)
    }
}