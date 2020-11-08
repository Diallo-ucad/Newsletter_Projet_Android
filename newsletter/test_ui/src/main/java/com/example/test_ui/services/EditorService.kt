package com.example.test_ui.services

import com.example.test_ui.model.ArticleDetailsObject
import com.example.test_ui.model.editor.EditorObject
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

