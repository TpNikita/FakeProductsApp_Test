package com.example.productlist_impl.data.repository

import com.example.data.Database
import com.example.data.ProductEntity
import com.example.productlist_impl.data.ProductListService
import com.example.productlist_impl.data.models.ProductResponse
import com.example.productlist_impl.domain.IProductListRepository
import javax.inject.Inject

class ProductListRepositoryImpl @Inject constructor(
    private val productListService: ProductListService,
    private val database: Database
) :
    IProductListRepository {

    /**
     * В приоритетном порядке список элементов запрашивается у бэка,
     * если по какой то причине произошла ошибка, то список запрашивается у БД.
     * При этом в соответствии с стратегией вставки для Insert(NONE),
     * в room будут добавляться только те элементы, ID которых еще нет в БД.
     */
    override suspend fun getAllProducts(): List<ProductResponse> {
        try {
            val result = productListService.getAllProducts()
            database.productDao().insertAll(result.map {
                ProductEntity(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    category = it.category,
                    description = it.description,
                    image = it.image,
                    isFavorite = false
                )
            })
            return result
        } catch (e: Exception) {
            return database.productDao().getAll().map {
                ProductResponse(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    category = it.category,
                    description = it.description,
                    image = it.image,
                    isFavorite = it.isFavorite
                )
            }
        }
    }

    override suspend fun doProductFavorite(productId: Int) {
        val productForChange = database.productDao().getProductById(productId)
        val updatedProductEntity = productForChange.copy(isFavorite = true)
        database.productDao().updateProduct(updatedProductEntity)
    }
}