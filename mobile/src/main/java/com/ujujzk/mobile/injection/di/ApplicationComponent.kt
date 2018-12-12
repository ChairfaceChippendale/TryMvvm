package com.ujujzk.mobile.injection.di

import android.app.Application
import com.ujujzk.domain.executor.PostExecutionThread
import com.ujujzk.mobile.ui.cats.CatsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun inject(fragment: CatsFragment)

    fun postExecutionThread(postExecutionThread: PostExecutionThread)
}