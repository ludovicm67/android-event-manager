package fr.ludovicm67.eventmanager.data


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EventDao {
    @Query("SELECT * FROM events")
    fun getAll(): LiveData<List<EventEntity>>

    @Query("SELECT * FROM events WHERE id = :id")
    fun findById(id: Int): LiveData<EventEntity>

    @Insert
    suspend fun insert(event: EventEntity): Long

    @Insert
    suspend fun insertAll(vararg event: EventEntity)

    @Delete
    suspend fun delete(event: EventEntity)

    @Update
    suspend fun update(vararg events: EventEntity)
}