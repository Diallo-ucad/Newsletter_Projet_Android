package com.example.test_ui.fragments.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_ui.MainActivity
import com.example.test_ui.R

import com.example.test_ui.adapters.CategoryRecyclerViewAdapter

import com.example.test_ui.model.Category
import com.example.test_ui.repository.Contents
import com.example.test_ui.utils.CellClickListener
import kotlinx.coroutines.launch

class CountryFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "Country"
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = Contents.countryList()

        val adapterRecycler = CategoryRecyclerViewAdapter(articles, cellClickListener)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        recyclerView.adapter = adapterRecycler

    }

}