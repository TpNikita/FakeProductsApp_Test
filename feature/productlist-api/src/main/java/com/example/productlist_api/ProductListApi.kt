package com.example.productlist_api

import com.example.feature_api.FeatureApi

interface ProductListApi : FeatureApi {
    val productListRoute: String
}