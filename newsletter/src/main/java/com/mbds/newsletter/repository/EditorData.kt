package com.mbds.newsletter.repository

import com.mbds.newsletter.model.ArticleItem
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.model.editor.EditorItem
import com.mbds.newsletter.services.ArticleService

import com.mbds.newsletter.services.EditorService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EditorData {
    private val service: EditorService
    private const val baseUrl: String = "https://newsapi.org/v2/"
    suspend fun dataList(apiKey: String): List<Category>{
        val response = service.list(apiKey = apiKey)
        val sources: List<EditorItem>? = response.body()?.sources
        var r : Int = 15
        if (sources != null) {
            return  sources.map{
                Category(
                    name = it.id,
                    label = it.name,
                    image = "https://picsum.photos/500/300?random=${r++}"
                )
            }
        }
        return emptyList()
    }
    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
        service = retrofit.create(EditorService::class.java)
    }
}