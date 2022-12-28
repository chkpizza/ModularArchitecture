package com.antique_boss.home.repo

import android.util.Log
import com.antique_boss.home.retrofit.PostService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val postService: PostService
) : HomeRepository {
    override suspend fun fetch() = withContext(Dispatchers.IO) {
        Log.d("HomeViewModel", "PostService: $postService")
        postService.getComments()
    }
}