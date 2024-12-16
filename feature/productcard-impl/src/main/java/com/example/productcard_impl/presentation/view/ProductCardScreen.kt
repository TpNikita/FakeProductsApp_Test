package com.example.productcard_impl.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.productcard_impl.presentation.viewModel.ProductCardViewModel

@Composable
fun ProductCardScreen(
    modifier: Modifier,
    viewModel: ProductCardViewModel,
    productId: Int?,
    navController: NavController
) {
    val scrollState = rememberScrollState()

    productId?.let { viewModel.getDetailInfoProduct(it) }

    val state = remember {
        viewModel.state
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.value.product == null) {
            Spacer(modifier = Modifier.height(48.dp))
            Text(text = "Загружаем данные", style = MaterialTheme.typography.titleLarge)
        } else {
            with(state.value.product!!) {
                Spacer(modifier = Modifier.height(28.dp))
                AsyncImage(

                    model = image,
                    contentDescription = description
                )

                Spacer(modifier = Modifier.height(28.dp))
                Text(text = title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = "Цена: $price руб.", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = "Категория: $category", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(14.dp))
                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text(text = "Назад")
                }
            }
        }
    }
}