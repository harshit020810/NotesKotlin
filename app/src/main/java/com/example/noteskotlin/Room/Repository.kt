package com.example.noteskotlin.Room

import androidx.lifecycle.LiveData

class Repository(private val modelDao: Dao) {

    val allNotes: LiveData<List<Model>> = modelDao.getAllNotes()

    suspend fun insert(model: Model){
        modelDao.insert(model)
    }

    suspend fun delete(model: Model){
        modelDao.delete(model)
    }
}