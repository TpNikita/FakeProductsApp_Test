package com.example.fakeproductsapp.main.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.di.DependencyProvider
import com.example.fakeproductsapp.R

enum class BottomTabs(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    val route: String
) {

    PRODUCT_LIST(
        R.string.products,
        R.drawable.ic_baseline_products,
        DependencyProvider.productListFeature().productListRoute
    ),
    FAVORITE_PRODUCT(
        R.string.favorite,
        R.drawable.ic_baseline_favorite,
        DependencyProvider.favoriteProductsFeature().favoriteProductsRoute
    )
}
