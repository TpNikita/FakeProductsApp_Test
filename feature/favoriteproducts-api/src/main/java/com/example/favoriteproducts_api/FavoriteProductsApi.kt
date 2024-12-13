package com.example.favoriteproducts_api

import com.example.feature_api.FeatureApi

interface FavoriteProductsApi : FeatureApi {

    val favoriteProductsRoute: String
}