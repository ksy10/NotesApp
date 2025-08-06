package com.example.notesapp.domain.repository

import com.example.notesapp.domain.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: String): Note?
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}