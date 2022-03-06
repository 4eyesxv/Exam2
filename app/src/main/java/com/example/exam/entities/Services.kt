package com.example.exam.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Category::class,
    parentColumns = arrayOf("idCategory"),
    childColumns = arrayOf("fkCategory"))))
data class Services (
    @PrimaryKey(autoGenerate = true) var idService: Int?,
    @ColumnInfo(name = "nameService") var nameService: String?,
    @ColumnInfo(name = "fkCategory") var fkCategory: Int?
    )

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) var idCategory: Int?,
    @ColumnInfo(name = "nameCategory") var nameCategory: String?
    )


@Entity
data class Payments (
    @PrimaryKey(autoGenerate = true) var idTransaction: Int?,
    @ColumnInfo(name = "nameTransaction") var nameTransaction: String?,
    @ColumnInfo(name = "personalAccount") var personalAccount: Int?,
    @ColumnInfo(name = "sumTransaction") var sumTransaction: Int?
    )