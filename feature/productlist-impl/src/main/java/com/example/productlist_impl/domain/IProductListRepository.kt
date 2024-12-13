package com.example.productlist_impl.domain

import com.example.productlist_impl.data.models.ProductResponse

interface IProductListRepository {

   suspend fun getAllProducts():List<ProductResponse>
}