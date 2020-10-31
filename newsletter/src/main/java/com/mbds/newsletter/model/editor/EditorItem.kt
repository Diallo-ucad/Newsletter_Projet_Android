package com.mbds.newsletter.model.editor

import java.util.*

data class EditorItem(
        val id: String,
        val name: String,
        val description: String,
        val url: String,
        val category: String,
        val language: String,
        val country: String
)