package fr.ludovicm67.eventmanager.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM users WHERE username = :username")
    fun findByUsername(username: String): LiveData<UserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    fun findById(id: Int): LiveData<UserEntity>

    @Insert
    suspend fun insertAll(vararg user: UserEntity)

    @Delete
    suspend fun delete(user: UserEntity)

    @Update
    suspend fun updateTodo(vararg users: UserEntity)
}