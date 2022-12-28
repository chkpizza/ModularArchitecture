package com.antique_boss.modulararchitecutre

import android.app.Application
import com.antique_boss.home.HomeComponentProvider
import com.antique_boss.home.di.HomeComponent
import com.antique_boss.modulararchitecutre.di.components.AppComponent
import com.antique_boss.modulararchitecutre.di.components.DaggerAppComponent
import com.antique_boss.mypage.MyPageComponentProvider
import com.antique_boss.mypage.di.MyPageComponent

class GlobalApplication : Application(), HomeComponentProvider, MyPageComponentProvider {
    val appComponent by lazy {
        initializeAppComponent()
    }

    private fun initializeAppComponent(): AppComponent {
        return DaggerAppComponent.factory().create()
    }

    override fun provideHomeComponent(): HomeComponent {
        return appComponent.getHomeComponent().create()
    }

    override fun provideMyPageComponent(): MyPageComponent {
        return appComponent.myPageComponent().create()
    }

    override fun onCreate() {
        super.onCreate()
    }

}