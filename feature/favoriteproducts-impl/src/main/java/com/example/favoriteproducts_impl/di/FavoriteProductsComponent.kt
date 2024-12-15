package com.example.favoriteproducts_impl.di

import android.content.Context
import com.example.di.ContextModule
import com.example.di.CoreComponent
import com.example.di.DatabaseModule
import com.example.favoriteproducts_impl.di.modules.FavoriteProductModule
import com.example.favoriteproducts_impl.navigation.FavoriteProductsImpl
import com.example.favoriteproducts_impl.presentation.viewModel.FavoriteProductViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DatabaseModule::class, FavoriteProductModule::class])
interface FavoriteProductsComponent : CoreComponent {

    fun inject(favoriteProductsImpl: FavoriteProductsImpl)

    companion object {
        fun getComponent(context: Context): FavoriteProductsComponent {
            return CoreComponent.getComponentHolder(context).get(
                FavoriteProductsComponent::class,
                Companion::create
            ) as FavoriteProductsComponent
        }

        private fun create(context: Context): CoreComponent =
            DaggerFavoriteProductsComponent.builder().contextModule(ContextModule(context)).build()
    }

    fun getFavoriteProductViewModels(): FavoriteProductViewModel
}