package com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    //Get note
    @Query("SELECT * FROM note WHERE id = :id") //Select everything where id = input
    suspend fun getNoteById(id: Int): Note? //suspend because directly return Note

    //if call insert with the existed id then update the note w the id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)






}