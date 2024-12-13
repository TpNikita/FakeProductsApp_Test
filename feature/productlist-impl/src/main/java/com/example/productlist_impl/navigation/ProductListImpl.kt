package com.example.productlist_impl.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.di.daggerViewModel
import com.example.productlist_api.ProductListApi
import com.example.productlist_impl.di.ProductListComponent
import com.example.productlist_impl.presentation.ProductListScreen
import com.example.productlist_impl.presentation.viewModel.ProductListViewModel

private const val baseRoute = "product_list"
private const val scenarioABRoute = "$baseRoute/scenario"
private const val screenBRoute = "$scenarioABRoute/B"
private const val screenARoute = "$scenarioABRoute/A"
private const val argumentKey = "arg"

class ProductListImpl : ProductListApi {
    override val productListRoute = baseRoute

    private var productComponent: ProductListComponent? = null

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(baseRoute) {
            val context = LocalContext.current

            if (productComponent == null) {
                productComponent = ProductListComponent.getComponent(context)
                productComponent?.inject(this@ProductListImpl)
            }

            val viewModel: ProductListViewModel = daggerViewModel {
                productComponent!!.getProductListViewModel()
            }

            ProductListScreen(
                modifier = modifier,
                onNavigateToABFlow = {
                    navController.navigate(scenarioABRoute)
                },
                viewModel
            )
        }
    }
}