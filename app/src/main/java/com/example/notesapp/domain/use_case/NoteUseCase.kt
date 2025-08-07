package com.example.notesapp.domain.use_case

import com.example.notesapp.domain.InvalidNoteException
import com.example.notesapp.domain.Note
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.util.NoteOrder
import com.example.notesapp.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.jvm.Throws

class NoteUseCase(private val noteRepository: NoteRepository) {

    fun getNotes(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {
        return noteRepository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }

    suspend fun deleteNote(note: Note) {
        noteRepository.deleteNote(note)
    }

    @Throws(InvalidNoteException::class)
    suspend fun insertNote(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        noteRepository.insertNote(note)
    }
}