package fr.ludovicm67.eventmanager.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "event")
data class Event(
    @PrimaryKey @ColumnInfo(name = "id") val eventId: Int,
    val name: String,
    val description: String,
    val creationDate: Date,
    val createdBy: Int,
    val eventDate: Date
) {
    override fun toString(): String {
        return "Event#${eventId}: $name"
    }
}
