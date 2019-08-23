package com.example.minimvvmexampleapp

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData


lateinit var categoryDAO: CategoryDAO
lateinit var bookDAO: BookDAO
lateinit private var categories: LiveData<List<Category>>
lateinit private var books: LiveData<List<Book>>

fun EBookShopRepo(application: Application){
    var booksDatabase: BooksDatabase = BooksDatabase.getInstance(application)
    categoryDAO = booksDatabase.categoryDAO()
    bookDAO = booksDatabase.bookDAO()
}

fun getCategories(): LiveData<List<Category>> {
    return categoryDAO.getAllCategories()
}

fun getBooks(categoryId: Int): LiveData<List<Book>> {
    return bookDAO.getBooks(categoryId)
}

//class InsertCategoryAsyncTask: AsyncTask<Category, Void, Void>() {
//    lateinit var categoryDAO: CategoryDAO
//
////    override fun doInBackground(vararg p0: Category?): Void {
////        categoryDAO.insert(categories)
////    }
//
//}
