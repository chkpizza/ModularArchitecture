package com.antique_boss.modulararchitecutre.di.modules

import androidx.lifecycle.ViewModel
import com.antique_boss.core.di.ViewModelKey
import com.antique_boss.modulararchitecutre.AppViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel::class)
    abstract fun bindAppViewModel(appViewModel: AppViewModel): ViewModel
}