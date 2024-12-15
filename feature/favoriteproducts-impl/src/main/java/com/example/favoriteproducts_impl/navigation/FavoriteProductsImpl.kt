package com.example.favoriteproducts_impl.navigation

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.di.daggerViewModel
import com.example.favoriteproducts_api.FavoriteProductsApi
import com.example.favoriteproducts_impl.di.FavoriteProductsComponent
import com.example.favoriteproducts_impl.presentation.view.FavoriteProductsScreen
import com.example.favoriteproducts_impl.presentation.viewModel.FavoriteProductViewModel

class FavoriteProductsImpl : FavoriteProductsApi {

    override val favoriteProductsRoute = "favorite_products"

    private var favoriteProductComponent: FavoriteProductsComponent? = null

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(favoriteProductsRoute) {
            val context = LocalContext.current

            if (favoriteProductComponent == null) {
                favoriteProductComponent = FavoriteProductsComponent.getComponent(context)
                favoriteProductComponent?.inject(this@FavoriteProductsImpl)
            }

            val viewModel: FavoriteProductViewModel = daggerViewModel {
                favoriteProductComponent!!.getFavoriteProductViewModels()
            }

            FavoriteProductsScreen(modifier = modifier, viewModel)
        }
    }
}