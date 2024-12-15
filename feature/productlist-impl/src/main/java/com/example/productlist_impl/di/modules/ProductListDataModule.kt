package com.example.productlist_impl.di.modules

import com.example.data.Database
import com.example.productlist_impl.data.ProductListService
import com.example.productlist_impl.data.repository.ProductListRepositoryImpl
import com.example.productlist_impl.domain.IProductListRepository
import com.example.productlist_impl.domain.usecase.GetAllProductsUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ProductListDataModule {

    @Provides
    fun provideProductListService(retrofit: Retrofit): ProductListService {
        return retrofit.create(ProductListService::class.java)
    }

    @Provides
    fun provideGetAllProductsUseCase(
        productRepository: IProductListRepository
    ): GetAllProductsUseCase {
        return GetAllProductsUseCase(productRepository)
    }

    @Provides
    fun provideProductListRepository(
        productListService: ProductListService,
        productDataBase: Database
    ): IProductListRepository {
        return ProductListRepositoryImpl(productListService, database = productDataBase)
    }
}