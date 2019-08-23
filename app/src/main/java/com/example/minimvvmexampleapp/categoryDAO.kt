package com.example.minimvvmexampleapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CategoryDAO {
    @Insert
    fun insert(category: Category): Void

    @Update
    fun update(category: Category): Void

    @Delete
    fun delete(category: Category): Void

    @Query("SELECT * FROM category_table ")
    fun getAllCategories(): LiveData<List<Category>>
}