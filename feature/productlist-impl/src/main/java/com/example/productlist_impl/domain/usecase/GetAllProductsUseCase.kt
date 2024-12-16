package com.example.productlist_impl.domain.usecase

import com.example.productlist_impl.domain.IProductListRepository
import com.example.productlist_impl.domain.models.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val productRepository: IProductListRepository
) {
    suspend fun getAllProducts(): Flow<List<Product>> {
        return productRepository.getAllProducts().map { productList ->
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