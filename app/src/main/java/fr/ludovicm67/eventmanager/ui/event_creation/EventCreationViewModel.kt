package fr.ludovicm67.eventmanager.ui.event_creation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventCreationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is event creation Fragment"
    }
    val text: LiveData<String> = _text
}