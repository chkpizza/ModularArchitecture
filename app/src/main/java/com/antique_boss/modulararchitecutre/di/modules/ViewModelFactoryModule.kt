package com.antique_boss.modulararchitecutre.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.antique_boss.home.HomeViewModelFactory
import com.antique_boss.mypage.MyPageViewModelFactory
import com.antique_boss.mypage.MyPageViewModelFactory_Factory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

@Module
abstract class ViewModelFactoryModule {


    @Binds
    @Named("HomeViewModelFactory")
    abstract fun bindHomeViewModelFactory(factory: HomeViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Named("MyPageViewModelFactory")
    abstract fun bindMyPageViewModelFactory(factory: MyPageViewModelFactory): ViewModelProvider.Factory


}