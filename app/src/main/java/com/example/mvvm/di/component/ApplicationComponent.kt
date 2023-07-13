package com.example.mvvm.di.component

import android.content.Context
import com.example.mvvm.MainActivity
import com.example.mvvm.data.api.NetworkService
import com.example.mvvm.data.repository.TopHeadlineRepository
import com.example.mvvm.di.ApplicationContext
import com.example.mvvm.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MainActivity)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository() : TopHeadlineRepository
}