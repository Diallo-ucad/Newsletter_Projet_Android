package com.mbds.newsletter.adapters

import android.text.format.DateUtils
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.mbds.newsletter.MainActivity
import com.mbds.newsletter.R

import com.mbds.newsletter.model.ArticleItem
import java.util.*

class ArticleRecyclerViewAdapter(
    private val values: List<ArticleItem>,
    val root: MainActivity
)
    : RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false)
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
        if (titleAuthor.size >= 2){
            holder.authorView.text = when(titleAuthor[1].length <= 25){
                true -> titleAuthor[1]
                else -> item.author
            }
        }else holder.authorView.text = ""

        holder.dateView.text = DateUtils.getRelativeTimeSpanString(
                item.publishedAt.time,
            Date().time,
            DateUtils.MINUTE_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        )
        Glide
            .with(holder.view)
            .load(item.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(holder.imgView)

        if (isArticleFav(item)){
            holder.btnFavView.setBackgroundResource(R.drawable.ic_favorite_round_24)
        }
        else {
            holder.btnFavView.setBackgroundResource(R.drawable.ic_favorite_border_24)
        }
        holder.btnFavView.setOnClickListener{
            if (isArticleFav(item)){
                holder.btnFavView.setBackgroundResource(R.drawable.ic_favorite_border_24)
                root.onRemoveFavArticle(item)
                Toast.makeText(root,"retiré des favoris", Toast.LENGTH_SHORT).show()
            }
            else {
                holder.btnFavView.setBackgroundResource(R.drawable.ic_favorite_round_24)
                root.onFavArticle(item)
                Toast.makeText(root,"ajouté aux favoris", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = values.size

    fun isArticleFav(articleItem: ArticleItem):Boolean{
        for (item: ArticleItem in root.getListArticlesFav()){
            if (item.url == articleItem.url) return true

        }
        return false
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.article_title)
        val imgView: ImageView = view.findViewById(R.id.article_img)
        val descriptionView: TextView = view.findViewById(R.id.article_description)
        val authorView: TextView = view.findViewById(R.id.article_author)
        val dateView: TextView = view.findViewById(R.id.article_date)
        val btnFavView: Button = view.findViewById(R.id.btn_favories)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}