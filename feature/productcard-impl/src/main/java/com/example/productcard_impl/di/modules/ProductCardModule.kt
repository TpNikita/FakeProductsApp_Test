package com.example.productcard_impl.di.modules

import com.example.data.Database
import com.example.productcard_impl.data.DetailInfoProductRepositoryImpl
import com.example.productcard_impl.domain.IDetailInfoProductRepository
import dagger.Module
import dagger.Provides

@Module
class ProductCardModule {

    @Provides
    fun provideProductCardRepository(productDatabase: Database): IDetailInfoProductRepository {
        return DetailInfoProductRepositoryImpl(productDatabase)
    }
}