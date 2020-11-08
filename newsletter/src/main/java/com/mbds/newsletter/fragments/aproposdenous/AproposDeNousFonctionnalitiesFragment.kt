package com.mbds.newsletter.fragments.aproposdenous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.newsletter.MainActivity
import com.mbds.newsletter.R
import com.mbds.newsletter.adapters.AproposDenousDeveloppersRecyclerViewAdapter
import com.mbds.newsletter.adapters.AproposDenousFonctionnalitiesRecyclerViewAdapter
import com.mbds.newsletter.adapters.ArticleRecyclerViewAdapter
import com.mbds.newsletter.adapters.CategoryRecyclerViewAdapter
import com.mbds.newsletter.changeFragment
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AproposDeNousFonctionnalitiesFragment(private val cellClickListener: CellClickListener) : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title = "A Propos De Nous"
        return inflater.inflate(R.layout.fragment_apropos_denous, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.fonctionalities_infos)
        val aproposdenousfontionnalitiesitem = Contents.aproposdenousFonctionalitiesList()

        val adapterRecycler = AproposDenousFonctionnalitiesRecyclerViewAdapter(aproposdenousfontionnalitiesitem, cellClickListener)
        recyclerView.layoutManager = GridLayoutManager(view.context, 1)
        recyclerView.adapter = adapterRecycler

    }

}