package com.example.noteskotlin.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    suspend fun insert(model: Model)

    @Delete
    suspend fun delete(model: Model)

    @Query("Select * from NOTES")
    fun getAllNotes() : LiveData<List<Model>>
}