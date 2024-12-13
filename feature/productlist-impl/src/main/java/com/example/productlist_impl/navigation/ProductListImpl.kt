package com.example.productlist_impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.productlist_api.ProductListApi
import com.example.productlist_impl.presentation.ProductListScreen

private const val baseRoute = "product_list"
private const val scenarioABRoute = "$baseRoute/scenario"
private const val screenBRoute = "$scenarioABRoute/B"
private const val screenARoute = "$scenarioABRoute/A"
private const val argumentKey = "arg"

class ProductListImpl : ProductListApi {
    override val productListRoute = baseRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            ProductListScreen(
                modifier = modifier,
                onNavigateToABFlow = {
                    navController.navigate(scenarioABRoute)
                }
            )
        }
    }
}