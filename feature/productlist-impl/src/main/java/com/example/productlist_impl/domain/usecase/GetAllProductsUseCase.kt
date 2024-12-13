package com.example.productlist_impl.domain.usecase

import com.example.productlist_impl.domain.IProductListRepository
import com.example.productlist_impl.domain.models.Product
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productRepository: IProductListRepository
) {
    suspend fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts().map {
            Product(
                id = it.id,
                title = it.title,
                price = it.price,
                category = it.category,
                description = it.description,
                image = it.image
            )
        }
    }
}