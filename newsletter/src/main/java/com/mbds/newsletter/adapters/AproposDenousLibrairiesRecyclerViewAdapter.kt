package com.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.newsletter.R
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_devInfoItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_fonctionalitieItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_librairiesItem
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener

class AproposDenousLibrairiesRecyclerViewAdapter(private val dataset: List<Aproposdenous_librairiesItem>, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<AproposDenousLibrairiesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        lateinit var aproposdenousLibrairiesitem: Aproposdenous_librairiesItem
        fun bind(item: Aproposdenous_librairiesItem) {
            aproposdenousLibrairiesitem = item

            /**
             * Recuperation des textview à partir du layout
             */
            val lib_name = root.findViewById<TextView>(R.id.librairie_name)
            val lib_description= root.findViewById<TextView>(R.id.librairie_description)
            /**
             * Initialisation des champs txt
             */
            lib_name.text=item.librairie_name.capitalize()
            lib_description.text=item.librairie_description.capitalize()
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.external_librairie_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                    dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
    }


