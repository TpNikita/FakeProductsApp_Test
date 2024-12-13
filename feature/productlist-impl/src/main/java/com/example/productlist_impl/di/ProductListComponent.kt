package com.example.productlist_impl.di

import android.content.Context
import com.example.di.CoreComponent
import com.example.di.NetworkModule
import com.example.productlist_impl.di.modules.ProductLIstDataModule
import com.example.productlist_impl.navigation.ProductListImpl
import com.example.productlist_impl.presentation.ProductListViewModel
import dagger.Component

@Component(modules = [NetworkModule::class, ProductLIstDataModule::class])
interface ProductListComponent : CoreComponent {

    fun inject(productListImpl: ProductListImpl)

    companion object {
        fun getComponent(context: Context): ProductListComponent {
            return CoreComponent.getComponentHolder(context)
                .get(ProductListComponent::class, Companion::create) as ProductListComponent
        }

        private fun create(context: Context): CoreComponent = DaggerProductListComponent.create()
    }

    fun getProductListViewModel(): ProductListViewModel
}