package com.antique_boss.modulararchitecutre.di.modules

import androidx.lifecycle.ViewModelProvider
import com.antique_boss.core.di.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Named

@Module
abstract class ViewModelFactoryModule {
    @Binds
    @Named("AppViewModelFactory")
    abstract fun bindAppViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Named("HomeViewModelFactory")
    abstract fun bindHomeViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Named("MyPageViewModelFactory")
    abstract fun bindMyPageViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}