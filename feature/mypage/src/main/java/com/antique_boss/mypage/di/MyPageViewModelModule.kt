package com.antique_boss.mypage.di

import androidx.lifecycle.ViewModel
import com.antique_boss.mypage.viewmodel.MyPageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MyPageViewModelModule {
    @Binds
    @IntoMap
    @MyPageViewModelKey(MyPageViewModel::class)
    abstract fun bindMyPageViewModel(viewModel: MyPageViewModel): ViewModel

}