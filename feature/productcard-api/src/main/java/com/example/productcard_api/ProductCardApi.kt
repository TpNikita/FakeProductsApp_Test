package com.example.productcard_api

import com.example.feature_api.FeatureApi

interface ProductCardApi : FeatureApi {
    val productCardRoute: String
}