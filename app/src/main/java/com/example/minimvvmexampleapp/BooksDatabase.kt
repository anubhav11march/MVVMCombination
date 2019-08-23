package com.example.minimvvmexampleapp

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = (arrayOf(Category::class, Book::class)), version = 1)
abstract class BooksDatabase : RoomDatabase(){



    abstract fun categoryDAO(): CategoryDAO
    abstract fun bookDAO(): BookDAO
    companion object {
        lateinit var instance: BooksDatabase
        fun getInstance(context: Context): BooksDatabase {
            if(instance == null){
                instance = Room
                    .databaseBuilder(context.applicationContext, BooksDatabase::class.java, "books_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            return instance
        }
        private val roomCallback = object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                InitialDataAsyncTask(instance).execute()

            }
        }

        class InitialDataAsyncTask(booksDatabase: BooksDatabase): AsyncTask<Void, Void, Void>() {
            lateinit var categoryDAO: CategoryDAO
            lateinit var bookDAO: BookDAO

            fun sad(){

            }

            fun InitialDataAsyncTask(booksDatabase: BooksDatabase){
                categoryDAO = booksDatabase.categoryDAO()
                bookDAO = booksDatabase.bookDAO()
            }

            override fun doInBackground(vararg p0: Void?): Void {
                var category1: Category = Category(0, "", "")
                category1.categoryName = "Text Books"
                category1.categoryDescription = "Books meant for curriculum reading"

                var category2: Category = Category(0, "", "")
                category2.categoryName = "Novels"
                category2.categoryDescription = "Books meant for leisure reading"

                var category3: Category = Category(0, "", "")
                category3.categoryName = "Other Books"
                category3.categoryDescription = "All other books category"

                categoryDAO.insert(category1)
                categoryDAO.insert(category2)
                categoryDAO.insert(category3)

                var book1: Book = Book(0, "", "", 0)
                book1.bookName = "Java"
                book1.bookPrice = "Rs. 450"
                book1.categoryId = 1

                var book2: Book = Book(0, "", "", 0)
                book2.bookName = "Mathematics"
                book2.bookPrice = "Rs. 600"
                book2.categoryId = 1

                var book3: Book = Book(0, "", "", 0)
                book3.bookName = "OOPs"
                book3.bookPrice = "Rs. 450"
                book3.categoryId = 1

                var book4 : Book = Book(0, "", "", 0)
                book4.bookName = "Astrology"
                book4.bookPrice = "Rs. 570"
                book4.categoryId = 1

                var book5: Book = Book(0, "", "", 0)
                book5.bookName = "Magic Tricks"
                book5.bookPrice = "Rs. 400"
                book5.categoryId = 1
                var book6: Book = Book(0, "", "", 0)
                book6.bookName = "Chemistry"
                book6.bookPrice = "Rs. 750"
                book6.categoryId = 1
                var book7 : Book = Book(0, "", "", 0)
                book7.bookName = "Cat Games Novel"
                book7.bookPrice = "Rs. 60"
                book7.categoryId = 2

                var book8: Book = Book(0, "", "", 0)
                book8.bookName = "Hound of NY"
                book8.bookPrice = "Rs. 51"
                book8.categoryId = 2
                var book9 : Book = Book(0, "", "", 0)
                book9.bookName = "Joe Adventures"
                book9.bookPrice = "Rs. 39"
                book9.categoryId = 2

                var book10 : Book = Book(0, "", "", 0)
                book10.bookName = "Witches Arc"
                book10.bookPrice = "Rs. 59"
                book10.categoryId = 2
                var book11 : Book = Book(0, "", "", 0)
                book11.bookName = "Caan I run"
                book11.bookPrice = "Rs. 50"
                book11.categoryId = 2
                var book12 : Book = Book(0, "", "", 0)
                book12.bookName = "Alien"
                book12.bookPrice = "Rs. 6000"
                book12.categoryId = 3
                var book13 : Book = Book(0, "", "", 0)
                book13.bookName = "Myths"
                book13.bookPrice = "Rs. 320"
                book13.categoryId = 3

                bookDAO.insert(book1)
                bookDAO.insert(book2)
                bookDAO.insert(book3)
                bookDAO.insert(book4)
                bookDAO.insert(book5)
                bookDAO.insert(book6)
                bookDAO.insert(book7)
                bookDAO.insert(book8)
                bookDAO.insert(book9)
                bookDAO.insert(book10)
                bookDAO.insert(book11)
                bookDAO.insert(book12)
                return bookDAO.insert(book13)


            }

        }
    }



}