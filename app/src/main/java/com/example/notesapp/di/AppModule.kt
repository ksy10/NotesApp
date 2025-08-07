package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.NoteDatabase.Companion.DATABASE_NAME
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.repository.NoteRepositoryImpl
import com.example.notesapp.domain.use_case.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(app, NoteDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository): NoteUseCase {
        return NoteUseCase(repository)
    }
}