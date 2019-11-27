package fr.ludovicm67.eventmanager.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.ludovicm67.eventmanager.data.AppDatabase

class RegisterViewModelFactory(
    private val db: AppDatabase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(db) as T
    }
}