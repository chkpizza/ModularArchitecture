package com.antique_boss.modulararchitecutre.di.modules

import androidx.lifecycle.ViewModelProvider
import com.antique_boss.home.HomeViewModelFactory
import com.antique_boss.mypage.MyPageViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @Named("HomeViewModelFactory")
    abstract fun bindHomeViewModelFactory(factory: HomeViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Named("MyPageViewModelFactory")
    abstract fun bindMyPageViewModelFactory(factory: MyPageViewModelFactory): ViewModelProvider.Factory


}