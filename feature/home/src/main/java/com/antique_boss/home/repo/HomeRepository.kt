package com.antique_boss.home.repo

import com.antique_boss.home.model.Comments
import retrofit2.Response

interface HomeRepository {
    suspend fun fetch(): Response<Comments>
}