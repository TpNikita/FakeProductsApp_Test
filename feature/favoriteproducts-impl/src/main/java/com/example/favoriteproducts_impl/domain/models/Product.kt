package com.example.favoriteproducts_impl.domain.models

data class Product(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
    val isFavorite: Boolean
)