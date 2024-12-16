package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM productEntity")
    fun getAll(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM productEntity WHERE isFavorite = true")
    fun getAllFavoriteProduct(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM productEntity WHERE id = :productId")
    fun getProductById(productId: Int): ProductEntity

    @Insert
    fun insertAll(products: List<ProductEntity>)

    @Insert
    fun insertProduct(product: ProductEntity)

    @Update
    fun updateProduct(product: ProductEntity):Int
}