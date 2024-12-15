package com.example.productlist_impl.di

import android.content.Context
import com.example.di.ContextModule
import com.example.di.CoreComponent
import com.example.di.DatabaseModule
import com.example.di.NetworkModule
import com.example.productlist_impl.di.modules.ProductListDataModule
import com.example.productlist_impl.navigation.ProductListImpl
import com.example.productlist_impl.presentation.viewModel.ProductListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ProductListDataModule::class, ContextModule::class, DatabaseModule::class])
interface ProductListComponent : CoreComponent {

    fun inject(productListImpl: ProductListImpl)

    companion object {
        fun getComponent(context: Context): ProductListComponent {
            return CoreComponent.getComponentHolder(context)
                .get(ProductListComponent::class, Companion::create) as ProductListComponent
        }

        private fun create(context: Context): CoreComponent = DaggerProductListComponent.builder().contextModule(ContextModule(context)).build()
    }

    fun getProductListViewModel(): ProductListViewModel
}