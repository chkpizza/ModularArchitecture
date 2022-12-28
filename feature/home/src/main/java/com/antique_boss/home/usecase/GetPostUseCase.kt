package com.antique_boss.home.usecase

import android.util.Log
import com.antique_boss.home.repo.HomeRepository
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend operator fun invoke() = repository.fetch()
}