package com.example.productcard_impl.domain.usecase

import com.example.productcard_impl.domain.IDetailInfoProductRepository
import com.example.productcard_impl.domain.models.Product
import javax.inject.Inject

class GetDetailInfoProductUseCase @Inject constructor(
    private val detailInfoProductRepository: IDetailInfoProductRepository
) {
    suspend fun getDetailInfoProduct(productId: Int): Product {
        val productEntity = detailInfoProductRepository.getDetailInfoProduct(productId)
        val product = Product(
            id = productEntity.id,
            title = productEntity.title,
            price = productEntity.price,
            category = productEntity.category,
            description = productEntity.description,
            image = productEntity.image,
            isFavorite = productEntity.isFavorite
        )
        return product
    }
}