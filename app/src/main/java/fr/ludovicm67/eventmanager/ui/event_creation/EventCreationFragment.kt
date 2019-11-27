package fr.ludovicm67.eventmanager.ui.event_creation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import fr.ludovicm67.eventmanager.R
import fr.ludovicm67.eventmanager.data.AppDatabase
import fr.ludovicm67.eventmanager.data.EventEntity
import fr.ludovicm67.eventmanager.ui.register.RegisterFragment

class EventCreationFragment : Fragment() {

    private val viewModel: EventCreationViewModel by viewModels {
        EventCreationViewModelFactory(AppDatabase(requireContext().applicationContext))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn: Button = view.findViewById(R.id.event_creation_button)
        btn.setOnClickListener {
            val nameInput: TextView = view.findViewById(R.id.event_creation_name)
            val descriptionInput: TextView = view.findViewById(R.id.event_creation_description)
            val name: String = nameInput.text.toString()
            val description: String = descriptionInput.text.toString()
            val event = EventEntity(
                name = name,
                description = description
            )
            viewModel.create(event)

            it.findNavController().navigate(R.id.nav_home)
        }
    }
}