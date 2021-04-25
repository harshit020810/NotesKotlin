package com.example.noteskotlin.Adapter

import android.content.Context
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteskotlin.R
import com.example.noteskotlin.Room.Model

class RecyclerViewAdapter(private val context: Context, private val listener: NotesAdapter): RecyclerView.Adapter<RecyclerViewAdapter.NoteViewHolder>() {


    private val fitNotes = ArrayList<Model>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.text)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false))
        view.textView.setOnClickListener {
            listener.onItemClicked(fitNotes[view.adapterPosition])
        }
        return view
    }

    override fun getItemCount(): Int {
       return fitNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = fitNotes[position]
        holder.textView.text = item.noteText

    }

    fun updateList(notes: List<Model>){
        fitNotes.clear()
        fitNotes.addAll(notes)
        notifyDataSetChanged()
    }
}

interface NotesAdapter{
    fun onItemClicked(model: Model)
}