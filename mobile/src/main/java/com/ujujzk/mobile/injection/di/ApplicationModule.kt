package com.ujujzk.mobile.injection.di

import android.app.Application
import android.content.Context
import com.ujujzk.data.cats.CatsGatewayImpl
import com.ujujzk.domain.gateway.CatGateway
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideCatGateway(gateway: CatsGatewayImpl): CatGateway = gateway

}