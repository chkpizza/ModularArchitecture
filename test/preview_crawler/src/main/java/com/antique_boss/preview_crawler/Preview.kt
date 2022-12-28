package com.antique_boss.preview_crawler

data class Preview(
    val url: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val siteName: String,
    val favicon: String
)