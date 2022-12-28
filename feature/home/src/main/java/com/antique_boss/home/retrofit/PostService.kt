package com.antique_boss.home.retrofit

import com.antique_boss.home.model.Comments
import retrofit2.Response
import retrofit2.http.GET

interface PostService {
    @GET("/comments")
    suspend fun getComments(): Response<Comments>
}