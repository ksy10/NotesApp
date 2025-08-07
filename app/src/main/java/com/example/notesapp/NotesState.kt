package com.example.notesapp

import com.example.notesapp.domain.Note
import com.example.notesapp.domain.util.NoteOrder
import com.example.notesapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val  isOrderSelectionVisible: Boolean = false
)
