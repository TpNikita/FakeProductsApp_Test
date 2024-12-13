package com.example.di

import com.example.favoriteproducts_api.FavoriteProductsApi
import com.example.productcard_api.ProductCardApi
import com.example.productlist_api.ProductListApi

/**
 * TODO позднее будет заменен на полноценный DI
 */
object DependencyProvider {


    private lateinit var favoriteProductsApi: FavoriteProductsApi
    private lateinit var productCardApi: ProductCardApi
    private lateinit var productListApi: ProductListApi

    fun provideImpl(
        favoriteProductsApi: FavoriteProductsApi,
        productCardApi: ProductCardApi,
        productListApi: ProductListApi
    ) {
        this.favoriteProductsApi = favoriteProductsApi
        this.productCardApi = productCardApi
        this.productListApi = productListApi
    }

    fun favoriteProductsFeature(): FavoriteProductsApi = favoriteProductsApi

    fun productCardFeature(): ProductCardApi = productCardApi

    fun productListFeature(): ProductListApi = productListApi
}