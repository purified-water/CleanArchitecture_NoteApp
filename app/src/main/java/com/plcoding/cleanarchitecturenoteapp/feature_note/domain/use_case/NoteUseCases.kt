package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    //after this //set up dependency injection lib dagger hilt
    val addNote: AddNote,
    val getNote: GetNote
)
