package com.example.productcard_impl.di

import android.content.Context
import com.example.di.ContextModule
import com.example.di.CoreComponent
import com.example.di.DatabaseModule
import com.example.productcard_impl.di.modules.ProductCardModule
import com.example.productcard_impl.navigation.ProductCardImpl
import com.example.productcard_impl.presentation.viewModel.ProductCardViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DatabaseModule::class, ProductCardModule::class])
interface ProductCardComponent : CoreComponent {

    fun inject(productCardImpl: ProductCardImpl)

    companion object {
        fun getComponent(context: Context): ProductCardComponent {
            return CoreComponent.getComponentHolder(context)
                .get(ProductCardComponent::class, Companion::create) as ProductCardComponent
        }

        private fun create(context: Context): CoreComponent =
            DaggerProductCardComponent.builder().contextModule(
                ContextModule(context)
            ).build()
    }

    fun getProductCardViewModel(): ProductCardViewModel
}