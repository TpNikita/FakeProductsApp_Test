package com.example.productlist_impl.data.repository

import com.example.data.Database
import com.example.data.ProductEntity
import com.example.productlist_impl.data.ProductListService
import com.example.productlist_impl.data.models.ProductResponse
import com.example.productlist_impl.domain.IProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val productListService: ProductListService,
    private val database: Database
) :
    IProductListRepository {
    override suspend fun getAllProducts(): List<ProductResponse> {
        try {
            val result = productListService.getAllProducts()
            database.productDao().insertAll(result.map {
                ProductEntity(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    category = it.category,
                    description = it.description,
                    image = it.image
                )
            })
            return result
        } catch (e: Exception) {
            return database.productDao().getAll().map {
                ProductResponse(
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
}