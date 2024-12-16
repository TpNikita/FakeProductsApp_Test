package com.example.productcard_impl.domain

import com.example.data.ProductEntity

interface IDetailInfoProductRepository {

   suspend fun getDetailInfoProduct(productId: Int): ProductEntity
}