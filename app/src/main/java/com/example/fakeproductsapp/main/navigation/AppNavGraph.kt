package com.example.fakeproductsapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.di.DependencyProvider
import com.example.feature_api.register


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = DependencyProvider.productListFeature().productListRoute
    ) {
        register(
            DependencyProvider.productListFeature(),
            navController = navController,
            modifier = modifier
        )

        register(
            DependencyProvider.favoriteProductsFeature(),
            navController = navController,
            modifier = modifier
        )

        register(
            DependencyProvider.productCardFeature(),
            navController = navController,
            modifier = modifier
        )
    }
}
