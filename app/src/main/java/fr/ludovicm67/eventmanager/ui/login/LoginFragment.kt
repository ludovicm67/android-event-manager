package fr.ludovicm67.eventmanager.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import fr.ludovicm67.eventmanager.MainActivity

import fr.ludovicm67.eventmanager.R
import fr.ludovicm67.eventmanager.data.AppDatabase
import fr.ludovicm67.eventmanager.ui.register.RegisterFragment

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(AppDatabase(requireContext().applicationContext))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn: Button = view.findViewById(R.id.login_button)
        btn.setOnClickListener {
            val usernameInput: TextView = view.findViewById(R.id.login_username)
            val username: String = usernameInput.text.toString()
            viewModel.login(username)
        }

        val register: TextView = view.findViewById(R.id.login_register)
        register.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.auth_container, RegisterFragment.newInstance())
                ?.commit()
        }
    }
}
