package fr.ludovicm67.eventmanager.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class User(
    @PrimaryKey @ColumnInfo(name = "id") val userId: Int,
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatar: String,
    val activated: Boolean,
    val createdAt: Date
)