package com.example.productlist_impl.domain

import com.example.data.ProductEntity
import kotlinx.coroutines.flow.Flow

interface IProductListRepository {

    suspend fun getAllProducts(): Flow<List<ProductEntity>>

    suspend fun doProductFavorite(productId: Int)
}