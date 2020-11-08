package com.example.test_ui.fragments.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_ui.R
import com.example.test_ui.model.Category
import com.example.test_ui.repository.Contents
import com.mbds.newsletter.adapters.ArticleDetailsRecyclerViewAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class ArticleDetailsFragment(private val category: Category) : Fragment() {
    private var columnCount = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.title = "Detail des articles - ${category.label.toLowerCase()}"

        val view = inflater.inflate(R.layout.fragment_article_details, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                GlobalScope.launch(Dispatchers.Main) {
                    adapter = Contents.categoryArticles[category.name]?.let {
                        ArticleDetailsRecyclerViewAdapter(it)
                    }
                    layoutManager = GridLayoutManager(view.context, 1)
                }

            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"
    }
}