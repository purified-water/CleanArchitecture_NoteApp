package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        //only create note when it has been validated
        //aka title and content is not blank
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title cannot be empty!")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content cannot be empty!")
        }
        repository.insertNote(note)
    }
}
