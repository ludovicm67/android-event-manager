package fr.ludovicm67.eventmanager.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_user")
data class CurrentUserEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "user_id") val userId: Int
)