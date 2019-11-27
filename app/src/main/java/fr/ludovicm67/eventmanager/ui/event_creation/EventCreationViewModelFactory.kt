package fr.ludovicm67.eventmanager.ui.event_creation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.ludovicm67.eventmanager.data.AppDatabase

class EventCreationViewModelFactory(
    private val db: AppDatabase
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EventCreationViewModel(db) as T
    }
}