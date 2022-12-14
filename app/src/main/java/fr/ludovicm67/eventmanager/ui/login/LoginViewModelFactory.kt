package fr.ludovicm67.eventmanager.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.ludovicm67.eventmanager.data.AppDatabase

class LoginViewModelFactory(
    private val db: AppDatabase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(db) as T
    }
}