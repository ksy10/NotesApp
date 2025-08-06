package com.example.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.domain.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}