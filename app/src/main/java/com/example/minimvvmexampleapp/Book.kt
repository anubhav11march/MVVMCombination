package com.example.minimvvmexampleapp

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "books_table", foreignKeys = [ForeignKey(entity = Category::class, parentColumns = ["id"],
    childColumns = ["category_id"], onDelete = CASCADE)])
data class Book(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "book_id") var bookId: Int,
                @ColumnInfo(name = "book_name") var bookName: String,
                @ColumnInfo(name = "book_price") var bookPrice: String,
                @ColumnInfo(name = "category_id") var categoryId: Int) : BaseObservable(){
    var bookId_: Int
        @Bindable get() = bookId
        set(value) {
            bookId = value
            notifyPropertyChanged(BR.bookId_)
        }

    var bookName_: String
        @Bindable get() = bookName
        set(value) {
            bookName = value
            notifyPropertyChanged(BR.bookName_)
        }

    var bookPrice_: String
        @Bindable get() = bookPrice
        set(value) {
            bookPrice = value
            notifyPropertyChanged(BR.bookPrice_)

        }

    var categoryId_: Int
        @Bindable get() = categoryId
        set(value) {
            categoryId = value
            notifyPropertyChanged(BR.categoryId_)
        }
}