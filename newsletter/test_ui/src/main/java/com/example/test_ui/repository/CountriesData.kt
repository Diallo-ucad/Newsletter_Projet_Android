package com.example.test_ui.repository

import com.example.test_ui.model.Category

object CountriesData {
    val dataList = listOf(
        Category(
            name = "fr",
            label = "france",
            image = "https://i.picsum.photos/id/1075/500/300.jpg?hmac=5DhRFK2dTT-URjGdj3Fgb8fBZOGnqy-lIR1gIm_JJ3U"
        ),
        Category(
            name = "us",
            label = "USA",
            image = "https://picsum.photos/500/300?random=1"
        ),
        Category(
            name = "en",
            label = "angleterre",
            image = "https://picsum.photos/500/300?random=2"
        ),
        Category(
            name = "ch",
            label = "chine",
            image = "https://picsum.photos/500/300?random=3"
        )//,
       // Category(
        //    name = "technology",
        //    image = "https://picsum.photos/500/300?random=6"
       // )
    )
}