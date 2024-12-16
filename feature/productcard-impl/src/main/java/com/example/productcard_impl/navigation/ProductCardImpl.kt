package com.example.productcard_impl.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.di.daggerViewModel
import com.example.productcard_api.ProductCardApi
import com.example.productcard_impl.di.ProductCardComponent
import com.example.productcard_impl.presentation.view.ProductCardScreen
import com.example.productcard_impl.presentation.viewModel.ProductCardViewModel

const val PRODUCT_ID_KEY = "productId"

class ProductCardImpl : ProductCardApi {
    override val productCardRoute: String = "product_card/"

    private var productCardComponent: ProductCardComponent? = null

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(
            "$productCardRoute{$PRODUCT_ID_KEY}",
            arguments = listOf(navArgument(PRODUCT_ID_KEY) {
                type = NavType.IntType
            })
        ) {
            val context = LocalContext.current

            val productId = it.arguments?.getInt(PRODUCT_ID_KEY)

            if (productCardComponent == null) {
                productCardComponent = ProductCardComponent.getComponent(context)
                productCardComponent?.inject(this@ProductCardImpl)
            }

            val viewModel: ProductCardViewModel = daggerViewModel {
                productCardComponent!!.getProductCardViewModel()
            }

            ProductCardScreen(modifier = modifier, viewModel, productId, navController)
        }
    }
}