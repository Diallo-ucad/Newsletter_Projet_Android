package com.mbds.newsletter

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mbds.newsletter.fragments.AcceuilFragment
import com.mbds.newsletter.fragments.ArticlesFragment
import com.mbds.newsletter.fragments.aproposdenous.AproposDeNousFonctionnalitiesFragment
import com.mbds.newsletter.fragments.aproposdenous.AproposDeNousdeveloppersFragment
import com.mbds.newsletter.fragments.aproposdenous.AproposDeNouslibrairiesFragment
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

        setContentView(R.layout.activity_main)
        changeFragment(AcceuilFragment(this))

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
    /**
     * gestion des menus
     */

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.page_1) {
            changeFragment(AcceuilFragment(this))
            return true
        }
        if (id == R.id.page_2) {
            changeFragment(ArticleFavorisFragment(this))
            return true
        }
        if (id == R.id.page_3) {
           changeFragment(AproposDeNousdeveloppersFragment(this))
            return true
        }
        if (id == R.id.page_4) {
            changeFragment(AproposDeNousFonctionnalitiesFragment(this))
            return true
        }
        if (id == R.id.page_5) {
            changeFragment(AproposDeNouslibrairiesFragment(this))
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Les bouttons
    fun onClickToOpenLinkArticle(view: View){
        val uri: Uri = Uri.parse(view.tag as String)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
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