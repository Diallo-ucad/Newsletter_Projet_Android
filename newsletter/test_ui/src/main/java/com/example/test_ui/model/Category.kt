package com.example.test_ui.model

data class Category(
    val name: String,
    var label: String = name,
    val image: String
)