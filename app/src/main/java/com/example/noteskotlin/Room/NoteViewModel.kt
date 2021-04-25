package com.example.noteskotlin.Room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val repository : Repository
    val allNotes : LiveData<List<Model>>

    init{
        val dao = NoteDatabase.getDatabase(application).NoteDao()
        repository = Repository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(model: Model) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(model)
    }

    fun insertNote(model: Model) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(model)
    }
}