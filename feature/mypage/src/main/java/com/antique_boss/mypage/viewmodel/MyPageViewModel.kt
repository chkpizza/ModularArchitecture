package com.antique_boss.mypage.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.antique_boss.mypage.usecase.GetUserInfoUseCase
import javax.inject.Inject

class MyPageViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel() {
    fun test() {
        getUserInfoUseCase()
    }
}