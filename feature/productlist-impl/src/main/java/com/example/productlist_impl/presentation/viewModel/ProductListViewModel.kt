package com.example.productlist_impl.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productlist_impl.domain.usecase.DoProductFavoriteUseCase
import com.example.productlist_impl.domain.usecase.GetAllProductsUseCase
import com.example.productlist_impl.presentation.models.ProductListState
import com.example.productlist_impl.presentation.models.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val doProductFavoriteUseCase: DoProductFavoriteUseCase
) : ViewModel() {

    val state = mutableStateOf(ProductListState(emptyList()))

    fun loadAllProducts() {
        viewModelScope.launch {
            val resultAsync = async(Dispatchers.IO) { getAllProductsUseCase.getAllProducts() }
            val resultAfterAwait = resultAsync.await()
            resultAfterAwait.collectLatest { productList ->
                state.value = ProductListState(productList = productList.map {
                    ProductUIModel(
                        id = it.id,
                        title = it.title,
                        price = it.price,
                        category = it.category,
                        description = it.description,
                        image = it.image,
                        isFavorite = it.isFavorite
                    )
                })
            }
        }
    }

    fun doProductFavorite(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            doProductFavoriteUseCase.doProductFavorite(productId)
        }
    }
}