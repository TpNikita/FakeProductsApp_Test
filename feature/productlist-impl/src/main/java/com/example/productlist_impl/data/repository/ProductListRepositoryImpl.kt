package com.example.productlist_impl.data.repository

import com.example.data.Database
import com.example.data.ProductEntity
import com.example.productlist_impl.data.ProductListService
import com.example.productlist_impl.domain.IProductListRepository
import kotlinx.coroutines.flow.Flow
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
     *
     * Возвращает Flow БД
     */
    override suspend fun getAllProducts(): Flow<List<ProductEntity>> {
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
            return getAllProductDb()
        } catch (e: Exception) {
            return getAllProductDb()
        }
    }

    private fun getAllProductDb(): Flow<List<ProductEntity>> {
        return database.productDao().getAll()
    }

    override suspend fun doProductFavorite(productId: Int) {
        val productForChange = database.productDao().getProductById(productId)
        val updatedProductEntity = productForChange.copy(isFavorite = true)
        database.productDao().updateProduct(updatedProductEntity)
    }
}