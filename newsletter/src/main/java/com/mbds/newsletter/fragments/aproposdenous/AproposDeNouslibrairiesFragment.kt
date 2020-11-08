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
import com.mbds.newsletter.adapters.*
import com.mbds.newsletter.changeFragment
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AproposDeNouslibrairiesFragment(private val cellClickListener: CellClickListener) : Fragment() {

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

        val recyclerViewlibrairie: RecyclerView = view.findViewById(R.id.librairies_infos)
        val aproposdenousLibrairiesitem = Contents.aproposdenouslibrairiesList()

        val adapterRecycler = AproposDenousLibrairiesRecyclerViewAdapter(aproposdenousLibrairiesitem, cellClickListener)
        recyclerViewlibrairie.layoutManager = GridLayoutManager(view.context, 1)
        recyclerViewlibrairie.adapter = adapterRecycler

    }

}