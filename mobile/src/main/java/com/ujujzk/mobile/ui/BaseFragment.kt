package com.ujujzk.mobile.ui

import android.arch.lifecycle.ViewModelProvider
import android.support.v4.app.Fragment
import com.ujujzk.mobile.CatsApplication
import com.ujujzk.mobile.injection.di.ApplicationComponent
import javax.inject.Inject

abstract class BaseFragment : Fragment(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    val appComponent: ApplicationComponent by lazy (mode = LazyThreadSafetyMode.NONE){
        (activity?.application as CatsApplication).appComponent
    }
}