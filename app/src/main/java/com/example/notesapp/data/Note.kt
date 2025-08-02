package com.example.notesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.ui.theme.*

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
