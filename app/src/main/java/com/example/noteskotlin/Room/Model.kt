package com.example.noteskotlin.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Model(@ColumnInfo(name = "Title")@NonNull val noteTitle: String,
                 @ColumnInfo(name = "Text")@NonNull val noteText: String,
                 @ColumnInfo(name = "Image") val imagePath: String,
                 @PrimaryKey(autoGenerate = true)@NonNull val id: Int) {
}