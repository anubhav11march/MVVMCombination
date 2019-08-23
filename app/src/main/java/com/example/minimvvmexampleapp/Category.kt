package com.example.minimvvmexampleapp

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
class Category(@PrimaryKey(autoGenerate = true)@ColumnInfo var id: Int,
                    @ColumnInfo(name = "category_name") var categoryName: String,
                    @ColumnInfo(name = "category_description") var categoryDescription: String):BaseObservable(){

//    init {
//        id = 0
//        categoryName = ""
//        categoryDescription = ""
//    }
    var id_: Int
    @Bindable get() = id
    set(value) {
        id = value
        notifyPropertyChanged(BR.id_)
    }

    var categoryName_: String
        @Bindable get() = categoryName
    set(value) {
        categoryName = value
        notifyPropertyChanged(BR.categoryName_)
    }

    var categoryDescription_: String
    @Bindable get() = categoryDescription
    set(value) {
        categoryDescription = value
        notifyPropertyChanged(BR.categoryDescription_)
    }
}

