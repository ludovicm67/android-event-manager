package fr.ludovicm67.eventmanager.ui.register

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ludovicm67.eventmanager.data.*
import kotlinx.coroutines.launch

class RegisterViewModel(private val db: AppDatabase) : ViewModel() {
    fun register(user: UserEntity) {
        val userDao: UserDao = db.userDao()
        val currentUserDao: CurrentUserDao = db.currentUserDao()

        viewModelScope.launch {
            try {
                val userId: Int = userDao.insert(user).toInt()
                currentUserDao.clear()
                val currentUser = CurrentUserEntity(userId)
                currentUserDao.insertAll(currentUser)
            } catch (e: SQLiteConstraintException) {
                println("registration failed: username/email already used or missing field")
            }
        }
    }
}