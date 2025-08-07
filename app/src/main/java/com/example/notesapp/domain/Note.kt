package com.example.notesapp.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.ui.theme.Cream80
import com.example.notesapp.ui.theme.Lavender80
import com.example.notesapp.ui.theme.LightBlue
import com.example.notesapp.ui.theme.Peach80
import com.example.notesapp.ui.theme.SoftGreen
import com.example.notesapp.ui.theme.SoftPink

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(SoftPink, LightBlue, SoftGreen, Lavender80, Peach80, Cream80)
    }
}

class InvalidNoteException(message: String): Exception(message)