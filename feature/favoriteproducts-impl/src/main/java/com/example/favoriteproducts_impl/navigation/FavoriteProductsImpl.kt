package com.example.favoriteproducts_impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.favoriteproducts_api.FavoriteProductsApi
import com.example.favoriteproducts_impl.presentation.FavoriteProductsScreen

class FavoriteProductsImpl : FavoriteProductsApi {
    override val favoriteProductsRoute = "favorite_products"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(favoriteProductsRoute) {
            FavoriteProductsScreen(modifier = modifier)
        }
    }
}