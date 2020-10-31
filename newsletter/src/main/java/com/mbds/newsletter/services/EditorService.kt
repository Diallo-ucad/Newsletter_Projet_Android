package com.mbds.newsletter.services

import com.mbds.newsletter.model.ArticleObject
import com.mbds.newsletter.model.editor.EditorObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EditorService {
    @GET("sources")
    suspend fun list(
        @Query("apiKey") apiKey: String,
        @Query("language") country: String = "fr"
    ): Response<EditorObject>
}

