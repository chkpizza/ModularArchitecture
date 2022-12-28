package com.antique_boss.modulararchitecutre.di.modules

import androidx.lifecycle.ViewModelProvider
import com.antique_boss.home.HomeViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindHomeViewModelFactory(factory: HomeViewModelFactory): ViewModelProvider.Factory
}