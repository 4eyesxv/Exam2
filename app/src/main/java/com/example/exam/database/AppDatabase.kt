package com.example.exam.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exam.dao.CategoryDao
import com.example.exam.dao.PaymentsDao
import com.example.exam.dao.ServicesDao
import com.example.exam.entities.Category
import com.example.exam.entities.Payments
import com.example.exam.entities.Services

@Database(entities = [Services::class, Category::class, Payments::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CategoryDao(): CategoryDao
    abstract fun ServicesDao(): ServicesDao
    abstract fun PaymentsDao(): PaymentsDao
}