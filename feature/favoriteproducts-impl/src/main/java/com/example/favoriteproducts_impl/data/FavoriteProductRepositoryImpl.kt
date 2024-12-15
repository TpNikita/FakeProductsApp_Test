package com.example.favoriteproducts_impl.data

import com.example.data.Database
import com.example.data.ProductEntity
import com.example.favoriteproducts_impl.domain.IFavoriteProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteProductRepositoryImpl @Inject constructor(
    private val database: Database
) : IFavoriteProductRepository {

    override suspend fun getAllFavoriteProduct(): Flow<List<ProductEntity>> {
        return database.productDao().getAllFavoriteProduct()
    }

    override suspend fun removeProductFromFavorites(productId: Int) {
        val productForChange = database.productDao().getProductById(productId)
        val updatedProductEntity = productForChange.copy(isFavorite = false)
        database.productDao().updateProduct(updatedProductEntity)
    }
}