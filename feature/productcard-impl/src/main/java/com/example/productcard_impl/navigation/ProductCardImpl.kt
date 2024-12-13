package com.example.productcard_impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.productcard_api.ProductCardApi
import com.example.productcard_impl.presentation.ProductCardScreen

class ProductCardImpl : ProductCardApi {
    override val productCardRoute: String = "product_card"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(productCardRoute) {
            ProductCardScreen(modifier = modifier)
        }
    }
}