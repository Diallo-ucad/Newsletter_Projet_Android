package com.example.test_ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.test_ui.model.Category
import com.example.test_ui.fragments.categories.ArticleDetailsFragment
import com.example.test_ui.utils.CellClickListener



class MainActivity : AppCompatActivity(), CellClickListener, View.OnClickListener {

    private val cellClickListener: CellClickListener = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.article_details)

    }
    override fun onCellClickListener(category: Category) {
        println("Catégory cliquée : $category")
        changeFragment(ArticleDetailsFragment(category))
    }

    override fun onClick(view: View) {

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

}