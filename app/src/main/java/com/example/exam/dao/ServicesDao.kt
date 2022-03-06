package com.example.exam.dao

import androidx.room.*
import com.example.exam.entities.Services


@Dao
interface ServicesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addServices(vararg services: Services)

    @Query("SELECT * FROM Services")
    fun getAllServices(): Array<Services>

    @Delete
    fun deleteServices(services: Services)
}