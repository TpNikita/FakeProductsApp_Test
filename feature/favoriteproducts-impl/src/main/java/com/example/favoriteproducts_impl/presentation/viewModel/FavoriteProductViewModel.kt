package com.example.favoriteproducts_impl.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.favoriteproducts_impl.domain.usecase.GetAllFavoriteProductUseCase
import com.example.favoriteproducts_impl.domain.usecase.RemoveProductFromFavoritesUseCase
import com.example.favoriteproducts_impl.presentation.models.FavoriteProductListState
import com.example.favoriteproducts_impl.presentation.models.FavoriteProductUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoriteProductViewModel @Inject constructor(
    private val getAllFavoriteProductUseCase: GetAllFavoriteProductUseCase,
    private val removeProductFromFavoritesUseCase: RemoveProductFromFavoritesUseCase
) : ViewModel() {

    val state = mutableStateOf(FavoriteProductListState(emptyList()))

    fun loadAllFavoriteProduct() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllFavoriteProductUseCase.getAllFavoriteProduct().collectLatest {
                val favoriteProductList = it.map { product ->
                    FavoriteProductUIModel(
                        id = product.id,
                        title = product.title,
                        price = product.price,
                        category = product.category,
                        description = product.description,
                        image = product.image,
                    )
                }
                state.value = FavoriteProductListState(favoriteProductList)
            }
        }
    }

    fun removeProductFromFavorites(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            removeProductFromFavoritesUseCase.removeProductFromFavorites(productId)
        }
    }
}