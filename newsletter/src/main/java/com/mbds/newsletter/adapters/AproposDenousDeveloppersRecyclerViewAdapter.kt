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
import com.mbds.newsletter.repository.Contents
import com.mbds.newsletter.utils.CellClickListener

class AproposDenousDeveloppersRecyclerViewAdapter(private val dataset: List<Aproposdenous_devInfoItem>, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<AproposDenousDeveloppersRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        lateinit var aproposdenousDevInfoItem: Aproposdenous_devInfoItem
        fun bind(item: Aproposdenous_devInfoItem) {
            aproposdenousDevInfoItem = item

            val txtfirstName = root.findViewById<TextView>(R.id.developper_firstName)
            val txtlastName = root.findViewById<TextView>(R.id.developper_lastName)
            val dev_img = root.findViewById<ImageView>(R.id.developper_img)
            val githref = root.findViewById<TextView>(R.id.developper_git)


            Glide
                .with(root)
                .load(item.developper_img)
                .circleCrop()
                .placeholder(R.drawable.placeholder)
                .into(dev_img);


            txtfirstName.text=item.firstName.capitalize()
            txtlastName.text=item.lastName.capitalize()
            githref.text=item.developper_git.capitalize()
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val rootView =
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.aproposdenous_item, parent, false)
            return ViewHolder(rootView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(
                    dataset[position]

            )
        }

        override fun getItemCount(): Int = dataset.size
    }


