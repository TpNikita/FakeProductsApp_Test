package com.example.productlist_impl.domain.usecase

import com.example.productlist_impl.domain.IProductListRepository
import javax.inject.Inject

class DoProductFavoriteUseCase @Inject constructor(
    private val productRepository: IProductListRepository
) {
    suspend fun doProductFavorite(productId: Int) {
        productRepository.doProductFavorite(productId)
    }
}