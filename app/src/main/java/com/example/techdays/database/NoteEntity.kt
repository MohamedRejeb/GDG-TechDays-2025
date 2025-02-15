package com.example.techdays.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.UUID

// Timestamp
// Ms

@Entity
data class NoteEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = Date().time,

    @ColumnInfo(name = "created_at")
    val createdAt: Long = Date().time,
) {

    fun getUpdatedAtFormatted(): String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(createdAt)
        return  SimpleDateFormat("EEEE, MMM d").format(calendar.getTime())
    }

    fun getCreatedAtFormatted(): String {
        val calendar = Calendar.getInstance()
        calendar.time = Date(createdAt)
        return  SimpleDateFormat("EEEE, MMM d").format(calendar.getTime())
    }

}