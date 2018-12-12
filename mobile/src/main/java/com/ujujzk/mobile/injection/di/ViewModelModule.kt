package com.ujujzk.mobile.injection.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ujujzk.mobile.injection.ViewModelFactory
import com.ujujzk.mobile.ui.cats.CatsVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CatsVM::class)
    abstract fun bindCatsViewModel(catsViewModel: CatsVM): ViewModel
}