package com.mbds.newsletter.model

data class Category(
        val category: String,
        val country: String,
        val source: String,
        val name: String,
        var label: String = name,
        val image: String
)