package com.mbds.newsletter.services

import com.mbds.newsletter.model.ArticleObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService {
    @GET("top-headlines")
    suspend fun list(
            @Query("category") category: String,
            @Query("apiKey") apiKey: String,
            @Query("country") country: String,
            @Query("sources") sources: String,
    ): Response<ArticleObject>
}

