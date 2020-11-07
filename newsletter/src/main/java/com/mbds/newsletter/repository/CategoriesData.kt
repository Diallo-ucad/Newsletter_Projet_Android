package com.mbds.newsletter.repository

import com.mbds.newsletter.model.Category

object CategoriesData {
    val dataList = listOf(
        Category(
            category="business",
            source="",
            country="fr",
            name = "Catégory",
            label = "entreprise",
            image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"
        ),
        Category(
            category="entertainment",
            source="",
            country="fr",
            name = "Catégory",
            label = "divertissement",
            image = "https://picsum.photos/500/300?random=1"
        ),
        Category(
            category="general",
            source="",
            country="fr",
            name = "Catégory",
            label = "général",
            image = "https://picsum.photos/500/300?random=2"
        ),
        Category(
            category="health",
            source="",
            country="fr",
            name = "Catégory",
            label = "santé",
            image = "https://picsum.photos/500/300?random=3"
        ),
        Category(
            category="science",
            source="",
            country="fr",
            name = "Catégory",
            label = "sciences",
            image = "https://picsum.photos/500/300?random=4"
        ),
        Category(
            category="sports",
            source="",
            country="fr",
            name = "Catégory",
            image = "https://picsum.photos/500/300?random=5"
        )
    )
}