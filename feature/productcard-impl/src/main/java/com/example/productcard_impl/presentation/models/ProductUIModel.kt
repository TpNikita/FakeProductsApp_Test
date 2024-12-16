package com.example.productcard_impl.presentation.models

data class ProductUIModel(
    val id: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
    val isFavorite: Boolean
)