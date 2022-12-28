package com.antique_boss.home.di

import com.antique_boss.home.ui.DetailFragment
import com.antique_boss.home.ui.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeViewModelModule::class])
interface HomeComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)
}