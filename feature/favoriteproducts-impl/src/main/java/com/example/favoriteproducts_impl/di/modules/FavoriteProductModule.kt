package com.example.favoriteproducts_impl.di.modules

import com.example.data.Database
import com.example.favoriteproducts_impl.data.FavoriteProductRepositoryImpl
import com.example.favoriteproducts_impl.domain.IFavoriteProductRepository
import dagger.Module
import dagger.Provides

@Module
class FavoriteProductModule {

    @Provides
    fun provideFavoriteProductRepository(
        productDataBase: Database
    ): IFavoriteProductRepository {
        return FavoriteProductRepositoryImpl(
            database = productDataBase
        )
    }
}