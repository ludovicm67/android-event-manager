package fr.ludovicm67.eventmanager.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import fr.ludovicm67.eventmanager.R
import fr.ludovicm67.eventmanager.data.AppDatabase
import fr.ludovicm67.eventmanager.data.UserEntity
import fr.ludovicm67.eventmanager.ui.login.LoginFragment

class RegisterFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterFragment()
    }

    private val viewModel: RegisterViewModel by viewModels {
        RegisterViewModelFactory(AppDatabase(requireContext().applicationContext))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnLogin: TextView = view.findViewById(R.id.register_login)
        btnLogin.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.auth_container, LoginFragment.newInstance())
                ?.commit()
        }

        val btnRegister: Button = view.findViewById((R.id.register_button))
        btnRegister.setOnClickListener {
            val firstNameInput: TextView = view.findViewById(R.id.register_firstname)
            val lastNameInput: TextView = view.findViewById(R.id.register_lastname)
            val usernameInput: TextView = view.findViewById(R.id.register_username)
            val emailInput: TextView = view.findViewById(R.id.register_email)
            val passwordInput: TextView = view.findViewById(R.id.register_password)

            val firstName: String = firstNameInput.text.toString()
            val lastName: String = lastNameInput.text.toString()
            val username: String = usernameInput.text.toString()
            val email: String = emailInput.text.toString()
            val password: String = passwordInput.text.toString()
            if (!firstName.isBlank()
                && !lastName.isBlank()
                && !username.isBlank()
                && !email.isBlank()
                && !password.isBlank()) {
                val user = UserEntity(
                    firstName = firstName,
                    lastName = lastName,
                    username = username,
                    email = email,
                    password = password
                )
                viewModel.register(user)
            }

        }
    }
}
