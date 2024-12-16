package com.example.productcard_impl.data

import com.example.data.Database
import com.example.data.ProductEntity
import com.example.productcard_impl.domain.IDetailInfoProductRepository
import javax.inject.Inject

class DetailInfoProductRepositoryImpl @Inject constructor(
    private val database: Database
) : IDetailInfoProductRepository {
    override suspend fun getDetailInfoProduct(productId: Int): ProductEntity {
        return database.productDao().getProductById(productId)
    }
}