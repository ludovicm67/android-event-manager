package fr.ludovicm67.eventmanager.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrentUserDao {
    @Query("SELECT * FROM current_user")
    fun getAll(): LiveData<List<CurrentUserEntity>>

    @Query("SELECT * FROM current_user WHERE user_id = :id")
    fun findById(id: Int): LiveData<CurrentUserEntity>

    @Query("DELETE FROM current_user")
    suspend fun clear(): Void

    @Insert
    suspend fun insertAll(vararg user: CurrentUserEntity)

    @Delete
    suspend fun delete(user: CurrentUserEntity)
}