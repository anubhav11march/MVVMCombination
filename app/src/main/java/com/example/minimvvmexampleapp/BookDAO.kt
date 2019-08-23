package com.example.minimvvmexampleapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookDAO{
    @Insert
    fun insert(book: Book): Void

    @Update
    fun update(book: Book): Void

    @Delete
    fun delete(book: Book): Void

    @Query("SELECT * FROM books_table ")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * FROM books_table WHERE category_id ==:categoryId")
    fun getBooks(categoryId: Int): LiveData<List<Book>>
}