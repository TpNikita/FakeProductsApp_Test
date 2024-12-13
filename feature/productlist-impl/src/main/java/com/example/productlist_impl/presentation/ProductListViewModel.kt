package com.example.productlist_impl.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productlist_impl.domain.usecase.GetAllProductsUseCase
import com.example.productlist_impl.presentation.models.ProductListState
import com.example.productlist_impl.presentation.models.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

init {
    loadAllProducts()
}
    val state = mutableStateOf(ProductListState(emptyList()))

    private fun loadAllProducts() {
        viewModelScope.launch {
            val job1 = async(Dispatchers.IO) { getAllProductsUseCase.getAllProducts() }
            val result = job1.await()
            state.value = ProductListState(productList = result.map {
                ProductUIModel(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    category = it.category,
                    description = it.description,
                    image = it.image
                )
            })
        }
    }
}