package fr.ludovicm67.eventmanager.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ludovicm67.eventmanager.data.AppDatabase
import fr.ludovicm67.eventmanager.data.CurrentUserDao
import fr.ludovicm67.eventmanager.data.CurrentUserEntity
import fr.ludovicm67.eventmanager.data.UserDao
import kotlinx.coroutines.launch

class LoginViewModel(private val db: AppDatabase) : ViewModel() {
    fun login(username: String) {
        val userDao: UserDao = db.userDao()
        val currentUserDao: CurrentUserDao = db.currentUserDao()

        viewModelScope.launch {
            val userId: Int? = userDao.getUserIdFromUsername(username)
            userId?.let {
                currentUserDao.clear()
                val currentUser = CurrentUserEntity(it)
                currentUserDao.insertAll(currentUser)
            }
        }
    }
}
