package com.antique_boss.mypage.di

import com.antique_boss.mypage.ui.MyPageFragment
import dagger.Subcomponent

@Subcomponent(modules = [MyPageViewModelModule::class])
interface MyPageComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MyPageComponent
    }

    fun inject(myPageFragment: MyPageFragment)
}