package com.example.test_ui.model

import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

data class ArticleDetailsItem (
            val title: String,
            val url: String,
            val description: String,
            val urlToImage: String,
            val author: String,
            val publishedAt: Date,
            val content: String,
            val floatingActionButton : FloatingActionButton
)