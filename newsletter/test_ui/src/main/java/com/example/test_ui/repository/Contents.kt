package com.example.test_ui.repository

import com.example.test_ui.model.Category
import com.example.test_ui.model.ArticleDetailsItem
import com.example.test_ui.services.ArticleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object Contents {
    private val service: ArticleService
    private const val baseUrl: String = "http://newsapi.org/v2/"
    private const val apiKey: String = "1103f0429e98441f906d0866a01ce7cd"//"e547106de0e74054bf6ab4f63a9a2e59"
    private const val country: String = "fr"
    var isFetched = false

    val categoryArticles = mutableMapOf<String, List<ArticleDetailsItem>>()

    private suspend fun articleDetailsList(category: Category): List<ArticleDetailsItem> {
        val response = service.list(category = category.name, apiKey = apiKey, country = country)
        val articles: List<ArticleDetailsItem>? = response.body()?.articles
            ?.filter {
                !it.urlToImage.isNullOrBlank()
            }
        return  articles ?:emptyList()
    }
    suspend fun fetchAllArticles(){
        CategoriesData.dataList.forEach{
            val catName = it.name
            val listArticles = articleDetailsList(it)
            categoryArticles.put(catName, listArticles)
        }
        isFetched = true
    }
    fun categoryList(): List<Category> = CategoriesData.dataList
    fun countryList(): List<Category> = CountriesData.dataList
    suspend fun editorList(): List<Category> = EditorData.dataList(apiKey)
    init {
        // Loggin
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(ArticleService::class.java)
    }

}