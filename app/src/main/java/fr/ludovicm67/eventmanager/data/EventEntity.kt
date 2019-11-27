package fr.ludovicm67.eventmanager.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val eventId: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "date") val date: Date = Date(System.currentTimeMillis())
)