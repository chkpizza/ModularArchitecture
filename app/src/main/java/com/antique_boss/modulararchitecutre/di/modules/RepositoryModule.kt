package com.antique_boss.modulararchitecutre.di.modules

import com.antique_boss.home.repo.HomeRepository
import com.antique_boss.home.repo.HomeRepositoryImpl
import com.antique_boss.home.retrofit.PostService
import com.antique_boss.mypage.repo.MyPageRepository
import com.antique_boss.mypage.repo.MyPageRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideHomeRepository(postService: PostService): HomeRepository {
        return HomeRepositoryImpl(postService)
    }

    @Singleton
    @Provides
    fun provideMyPageRepository(): MyPageRepository {
        return MyPageRepositoryImpl()
    }
}