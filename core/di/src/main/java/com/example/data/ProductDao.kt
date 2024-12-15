package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("SELECT * FROM productEntity")
    fun getAll(): List<ProductEntity>

    @Insert
    fun insertAll(products: List<ProductEntity>)

    @Insert
    fun insertProduct(product: ProductEntity)
}