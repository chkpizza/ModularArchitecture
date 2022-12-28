package com.antique_boss.mypage.usecase

import android.util.Log
import com.antique_boss.mypage.repo.MyPageRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(
    private val repository: MyPageRepository
) {
    operator fun invoke(): String {
        Log.d("MyPageViewModel", "MyPageRepository: $repository")
        return repository.fetch()
    }
}