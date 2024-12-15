package com.example.favoriteproducts_impl.domain.usecase

import com.example.favoriteproducts_impl.domain.IFavoriteProductRepository
import com.example.favoriteproducts_impl.domain.models.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllFavoriteProductUseCase @Inject constructor(
    private val favoriteProductRepository: IFavoriteProductRepository
) {
    suspend fun getAllFavoriteProduct(): Flow<List<Product>> {
        return favoriteProductRepository.getAllFavoriteProduct().map { productList ->
            productList.map { product ->
                Product(
                    id = product.id,
                    title = product.title,
                    price = product.price,
                    category = product.category,
                    description = product.description,
                    image = product.image,
                    isFavorite = product.isFavorite
                )

            }
        }
    }
}