package com.antique_boss.modulararchitecutre.di.components

import com.antique_boss.home.di.HomeComponent
import com.antique_boss.modulararchitecutre.MainActivity
import com.antique_boss.modulararchitecutre.di.modules.RepositoryModule
import com.antique_boss.modulararchitecutre.di.modules.RetrofitModule
import com.antique_boss.modulararchitecutre.di.modules.ViewModelFactoryModule
import com.antique_boss.mypage.di.MyPageComponent
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SubcomponentsModule::class,
        ViewModelFactoryModule::class,
        RepositoryModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(mainActivity: MainActivity)

    fun getHomeComponent(): HomeComponent.Factory
    fun myPageComponent(): MyPageComponent.Factory
}

@Module(
    subcomponents = [
        HomeComponent::class,
        MyPageComponent::class
    ]
)
object SubcomponentsModule