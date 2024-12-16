package com.example.productlist_impl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.productlist_impl.presentation.viewModel.ProductListViewModel

@Composable
internal fun ProductListScreen(
    modifier: Modifier,
    onNavigateToABFlow: () -> Unit,
    viewModel: ProductListViewModel
) {

    viewModel.loadAllProducts()

    val state = remember {
        viewModel.state
    }
    LazyColumn(Modifier.padding(bottom = 48.0.dp)) {
        state.value.productList.forEach {
            item {
                productItem(
                    viewModel,
                    it.id,
                    it.title,
                    it.price,
                    it.image,
                    it.description,
                    it.isFavorite
                )
            }
        }
    }
}

@Composable
fun productItem(
    viewModel: ProductListViewModel,
    id: Int,
    title: String,
    price: String,
    url: String,
    description: String,
    isFavorite: Boolean
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = url, contentDescription = description, modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = price, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)

                if (!isFavorite) {
                    Button(onClick = { viewModel.doProductFavorite(id) }) {
                        Text(text = "Добавить в избранное")
                    }
                } else {
                    Text(text = "Добавлено в избранное")
                }
            }
        }
    }
}