package com.ujujzk.mobile

import android.app.Application
import com.ujujzk.mobile.injection.di.ApplicationComponent
import com.ujujzk.mobile.injection.di.ApplicationModule
import com.ujujzk.mobile.injection.di.DaggerApplicationComponent

class CatsApplication: Application() {


    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }



    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}