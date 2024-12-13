package com.example.productlist_impl.data

import com.example.productlist_impl.data.models.ProductResponse
import retrofit2.http.GET

interface ProductListService {

    @GET("products")
    suspend fun getAllProducts(): List<ProductResponse>
}