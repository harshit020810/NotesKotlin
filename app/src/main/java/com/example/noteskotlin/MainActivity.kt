package com.example.noteskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteskotlin.Adapter.NotesAdapter
import com.example.noteskotlin.Adapter.RecyclerViewAdapter
import com.example.noteskotlin.Room.Model
import com.example.noteskotlin.Room.NoteViewModel
import com.example.noteskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , NotesAdapter {

    lateinit var viewModel: NoteViewModel
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager =LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(this, this)
        binding.recycler.adapter = adapter

        viewModel = ViewModelProvider(this,
        ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }
        })


    }

    override fun onItemClicked(model: Model) {
        viewModel.deleteNote(model)
    }
}