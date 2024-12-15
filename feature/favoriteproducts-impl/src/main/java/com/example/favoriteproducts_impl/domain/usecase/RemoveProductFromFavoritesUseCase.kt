package com.example.favoriteproducts_impl.domain.usecase

import com.example.favoriteproducts_impl.domain.IFavoriteProductRepository
import javax.inject.Inject

class RemoveProductFromFavoritesUseCase @Inject constructor(
    private val favoriteProductRepository: IFavoriteProductRepository
) {
    suspend fun removeProductFromFavorites(productId: Int) {
        favoriteProductRepository.removeProductFromFavorites(productId)
    }
}