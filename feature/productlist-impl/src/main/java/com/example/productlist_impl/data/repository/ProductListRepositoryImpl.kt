package com.example.productlist_impl.data.repository

import com.example.productlist_impl.data.ProductListService
import com.example.productlist_impl.data.models.ProductResponse
import com.example.productlist_impl.domain.IProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val productListService: ProductListService
) :
    IProductListRepository {
    override suspend fun getAllProducts(): List<ProductResponse> {
        return productListService.getAllProducts()
    }
}