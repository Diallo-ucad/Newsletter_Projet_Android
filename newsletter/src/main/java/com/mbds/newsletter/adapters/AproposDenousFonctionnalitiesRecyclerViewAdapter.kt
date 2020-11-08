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
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener

class AproposDenousFonctionnalitiesRecyclerViewAdapter(private val dataset: List<Aproposdenous_fonctionalitieItem>, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<AproposDenousFonctionnalitiesRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        lateinit var aproposdenousFonctionalitieitem: Aproposdenous_fonctionalitieItem
        fun bind(item: Aproposdenous_fonctionalitieItem) {
            aproposdenousFonctionalitieitem = item


            val fonct_name = root.findViewById<TextView>(R.id.fonctionalitie_name)
            val fonct_description= root.findViewById<TextView>(R.id.fonctionalitie_description)

            fonct_name.text=item.fonctionalitie_name.capitalize()
            fonct_description.text=item.fonctionalitie_description.capitalize()
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.fonctionnalitie_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                    dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
    }


