package com.mbds.newsletter.fragments

import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleDetailsFragment(
    private val article: ArticleItem,
    private val root: MainActivity
) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_article_details, container, false)
        val contentView: TextView = view.findViewById(R.id.article_detail_title)
        val imgView: ImageView = view.findViewById(R.id.article_detail_img)
        val descriptionView: TextView = view.findViewById(R.id.article_detail_description)
        val authorView: TextView = view.findViewById(R.id.article_detail_author)
        val dateView: TextView = view.findViewById(R.id.article_detail_date)
        val btnFavView: Button = view.findViewById(R.id.btn_favories_detail)
        val btnOpenUri: Button = view.findViewById(R.id.btn_open_article_detail_to_nav)

        btnOpenUri.tag = article.url
        val description: String = when(article.description != null){
            true -> article.description
            else -> ""
        }

        val titleAuthor = article.title.split("-")
        contentView.text = titleAuthor[0]
        descriptionView.text = description
        if (titleAuthor.size >= 2){
            authorView.text = when(titleAuthor[1].length <= 25){
                true -> titleAuthor[1]
                else -> article.author
            }
        }else authorView.text = ""

        dateView.text = DateUtils.getRelativeTimeSpanString(
            article.publishedAt.time,
            Date().time,
            DateUtils.MINUTE_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        )
        Glide
            .with(view)
            .load(article.urlToImage)
            .centerCrop()
            .placeholder(R.drawable.placeholder)
            .into(imgView)

        if (root.isArticleFav(article)){
            btnFavView.setBackgroundResource(R.drawable.ic_favorite_round_24)
        }
        else {
            btnFavView.setBackgroundResource(R.drawable.ic_favorite_border_24)
        }
        btnFavView.setOnClickListener{
            if (root.isArticleFav(article)){
                btnFavView.setBackgroundResource(R.drawable.ic_favorite_border_24)
                root.onRemoveFavArticle(article)
                Toast.makeText(root,"retiré des favoris", Toast.LENGTH_SHORT).show()
            }
            else {
                btnFavView.setBackgroundResource(R.drawable.ic_favorite_round_24)
                root.onFavArticle(article)
                Toast.makeText(root,"ajouté aux favoris", Toast.LENGTH_SHORT).show()
            }
        }

        return view;
    }

    companion object {
    }
}