package com.antique_boss.mypage

import com.antique_boss.mypage.di.MyPageComponent

interface MyPageComponentProvider {
    fun provideMyPageComponent(): MyPageComponent
}