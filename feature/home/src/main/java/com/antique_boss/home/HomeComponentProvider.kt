package com.antique_boss.home

import com.antique_boss.home.di.HomeComponent

interface HomeComponentProvider {
    fun provideHomeComponent(): HomeComponent
}