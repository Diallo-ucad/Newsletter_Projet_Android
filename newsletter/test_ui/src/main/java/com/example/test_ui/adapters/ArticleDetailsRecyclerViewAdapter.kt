package com.mbds.newsletter.adapters

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_ui.R
import com.example.test_ui.model.ArticleDetailsItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class ArticleDetailsRecyclerViewAdapter(
    private val values: List<ArticleDetailsItem>

)
    : RecyclerView.Adapter<ArticleDetailsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_details, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val description: String = when(item.description != null){
            true -> item.description
            else -> ""
        }


        val titleAuthor = item.title.split("-")
        holder.contentView.text = titleAuthor[0]
        holder.descriptionView.text = description
        holder.authorView.text = when(titleAuthor[1].length <= 25){
            true -> titleAuthor[1]
            else -> item.author
        }
        holder.dateView.text = DateUtils.getRelativeTimeSpanString(
            item.publishedAt.time,
            Date().time,
            DateUtils.MINUTE_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        )


        Glide
            .with(holder.view)
            .load(item.urlToImage)
            .fitCenter()
            .placeholder(R.drawable.placeholder)
            .into(holder.imgView)



        Glide.with(holder.view)
            .load(item.floatingActionButton)
            .placeholder(R.drawable.heart_on)
            .into(holder.floatingActionButton);
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.articleDetails_title)
        val imgView: ImageView = view.findViewById(R.id.articleDetails_img)
        val descriptionView: TextView = view.findViewById(R.id.articleDetails_description)
        val authorView: TextView = view.findViewById(R.id.articleDetails_author)
        val dateView: TextView = view.findViewById(R.id.articleDetails_date)
        val floatingActionButton: FloatingActionButton = view.findViewById(R.id.favbtn)


        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

    inner class FavouriteBtn : Activity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_article_details)

            val imgButton = findViewById<ImageButton>(R.id.favbtn)
            imgButton.setOnClickListener ( object : View.OnClickListener{

               override fun onClick(view: View) {

                    var isFavourite = readState()
                    if (isFavourite) {
                        imgButton.setBackgroundResource(R.drawable.heart_on)
                        isFavourite = false
                        saveState(isFavourite)
                    } else {
                        imgButton.setBackgroundResource(R.drawable.heart_off)
                        isFavourite = true
                        saveState(isFavourite)
                    }
                }

            });
        }
        private fun saveState(isFavourite: Boolean) {
            val aSharedPreferences = getSharedPreferences(
                    "Favourite", Context.MODE_PRIVATE)
            val aSharedPreferencesEditor = aSharedPreferences
                    .edit()
            aSharedPreferencesEditor.putBoolean("State", isFavourite)
            aSharedPreferencesEditor.apply()
        }

        private fun readState(): Boolean {
            val aSharedPreferences = getSharedPreferences(
                    "Favourite", Context.MODE_PRIVATE)
            return aSharedPreferences.getBoolean("State", true)
        }

        fun onClick(view: View) {}

    }

}