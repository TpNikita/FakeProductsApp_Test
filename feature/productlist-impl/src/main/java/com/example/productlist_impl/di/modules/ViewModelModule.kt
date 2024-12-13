package com.example.productlist_impl.di.modules

import com.example.productlist_impl.domain.usecase.GetAllProductsUseCase
import com.example.productlist_impl.presentation.viewModel.ProductListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun getProductListViewModel(
        getAllProductsUseCase: GetAllProductsUseCase
    ): ProductListViewModel {
        return ProductListViewModel(getAllProductsUseCase)
    }
}