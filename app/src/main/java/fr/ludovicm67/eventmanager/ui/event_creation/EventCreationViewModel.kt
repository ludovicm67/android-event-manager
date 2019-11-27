package fr.ludovicm67.eventmanager.ui.event_creation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ludovicm67.eventmanager.data.*
import kotlinx.coroutines.launch

class EventCreationViewModel(private val db: AppDatabase) : ViewModel() {
    fun create(event: EventEntity) {
        val eventDao: EventDao = db.eventDao()

        viewModelScope.launch {
            eventDao.insert(event)
        }
    }
}