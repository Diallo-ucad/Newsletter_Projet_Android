package com.mbds.newsletter

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mbds.newsletter.fragments.AcceuilFragment
import com.mbds.newsletter.fragments.ArticlesFragment
import com.mbds.newsletter.fragments.aproposdenous.AproposDeNousdeveloppersFragment
import com.mbds.newsletter.fragments.favoris.ArticleFavorisFragment
import com.mbds.newsletter.model.ArticleItem
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.utils.CellClickListener


class MainActivity : AppCompatActivity(), CellClickListener {

    private var PRIVATE_MODE = 0
    private val PREF_NAME = "articles-favoris"
    private val sharedPref: SharedPreferences by lazy { getSharedPreferences(PREF_NAME, PRIVATE_MODE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //sharedPref.edit().clear().commit()
        setContentView(R.layout.activity_main)
        changeFragment(AcceuilFragment(this))
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> changeFragment(AcceuilFragment(this))
                R.id.page_2 -> changeFragment(ArticleFavorisFragment(this))
                R.id.page_3 -> changeFragment(AproposDeNousdeveloppersFragment(this))
            }
            true
        }
        /*
        if (Contents.isFetched.not()){
            val activityRout=this
            // Coroutine
            GlobalScope.launch(Dispatchers.Main) {
                Contents.fetchAllArticles()
               changeFragment(AcceuilFragment(activityRout))
            }
        }
        else {
             changeFragment(AcceuilFragment(this))
        }
         */
    }

    fun onFavArticle( article: ArticleItem){
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        val type = object : TypeToken<MutableList<ArticleItem?>?>() {}.type
        val articles = gson.fromJson<MutableList<ArticleItem>>(articlesString, type)
        articles.add(article)
        val articleToString: String = gson.toJson(articles)
        sharedPref.edit().putString(FAV_KEY, articleToString).commit()
    }

    fun onRemoveFavArticle( article: ArticleItem){
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        val type = object : TypeToken<MutableList<ArticleItem?>?>() {}.type
        val articles = gson.fromJson<MutableList<ArticleItem>>(articlesString, type)

        val articlesFilterd = articles.filter {
            it.url != article.url
        }
        val articleToString: String = gson.toJson(articlesFilterd)
        sharedPref.edit().putString(FAV_KEY, articleToString).commit()
    }

    fun getListArticlesFav(): List<ArticleItem>{
        val FAV_KEY = "article_fav"
        val gson: Gson = Gson()

        val articlesString = sharedPref.getString(FAV_KEY, "[]")
        println("------------------------------------------- $articlesString")
        val type = object : TypeToken<MutableList<ArticleItem?>?>() {}.type
        val articles = gson.fromJson<MutableList<ArticleItem>>(articlesString, type)
        return articles
    }

    override fun onCellClickListener(category: Category) {
        println("Catégory cliquée : $category")
        changeFragment(ArticlesFragment(category, this))
    }
}

/**
 * Ajouter le fragmet [ComputationFragment] dans l'activité
 */
fun MainActivity.changeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        //3) on remplace le contenu du container
        replace(R.id.fragment_container, fragment)
        //4) on ajoute la transaction dans la backstack
        addToBackStack(null)
    }.commit()
    // 5) on commit la transaction

}