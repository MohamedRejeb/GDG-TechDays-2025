package com.example.techdays.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("""
        SELECT * FROM noteentity 
        ORDER BY updated_at DESC
    """)
    fun getAll(): List<NoteEntity>

    @Query("SELECT * FROM noteentity WHERE id = :id")
    fun getOneById(id: String): NoteEntity

    @Insert
    fun insert(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

}