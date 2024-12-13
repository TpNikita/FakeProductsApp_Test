package com.example.fakeproductsapp.main.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.di.DependencyProvider
import com.example.favoriteproducts_impl.navigation.FavoriteProductsImpl
import com.example.productcard_impl.navigation.ProductCardImpl
import com.example.productlist_impl.navigation.ProductListImpl


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        DependencyProvider.provideImpl(
            favoriteProductsApi = FavoriteProductsImpl(),
            productCardApi = ProductCardImpl(),
            productListApi = ProductListImpl()
        )

        setContent {
            AppContent()
        }
    }
}