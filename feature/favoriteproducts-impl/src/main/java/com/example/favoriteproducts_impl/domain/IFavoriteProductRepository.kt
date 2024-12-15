package com.example.favoriteproducts_impl.domain

import com.example.data.ProductEntity
import kotlinx.coroutines.flow.Flow

interface IFavoriteProductRepository {

    suspend fun getAllFavoriteProduct(): Flow<List<ProductEntity>>

    suspend fun removeProductFromFavorites(productId: Int)
}