package com.example.mvvm.di.module

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.data.repository.TopHeadlineRepository
import com.example.mvvm.di.ActivityContext
import com.example.mvvm.ui.base.ViewModelProviderFactory
import com.example.mvvm.ui.topheadline.TopHeadlineAdapter
import com.example.mvvm.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule (private val activity: AppCompatActivity) {
    @ActivityContext
    @Provides
    fun provideContext(): Context{
        return  activity
    }

    @Provides
    fun provideTopHeadlineViewModel(topHeadlineRepository: TopHeadlineRepository): TopHeadlineViewModel{
        return ViewModelProvider(activity, ViewModelProviderFactory(TopHeadlineViewModel::class){
            TopHeadlineViewModel(topHeadlineRepository)
        })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}