package fr.ludovicm67.eventmanager.ui.event_creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.ludovicm67.eventmanager.R

class EventCreationFragment : Fragment() {

    private lateinit var eventCreationViewModel: EventCreationViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }
}