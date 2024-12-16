package com.example.productcard_impl.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.productcard_impl.domain.usecase.GetDetailInfoProductUseCase
import com.example.productcard_impl.presentation.models.ProductCardState
import com.example.productcard_impl.presentation.models.ProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductCardViewModel @Inject constructor(
    private val getDetailInfoProductUseCase: GetDetailInfoProductUseCase
) : ViewModel() {

    val state = mutableStateOf(ProductCardState(null))

    fun getDetailInfoProduct(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val product = getDetailInfoProductUseCase.getDetailInfoProduct(productId)

            val productUIModel = ProductUIModel(
                id = product.id,
                title = product.title,
                price = product.price,
                category = product.category,
                description = product.description,
                image = product.image,
                isFavorite = product.isFavorite
            )

            state.value = ProductCardState(productUIModel)
        }
    }
}