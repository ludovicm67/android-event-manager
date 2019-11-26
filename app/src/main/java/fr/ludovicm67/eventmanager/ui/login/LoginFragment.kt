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
import fr.ludovicm67.eventmanager.MainActivity

import fr.ludovicm67.eventmanager.R
import fr.ludovicm67.eventmanager.ui.register.RegisterFragment

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

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
            activity?.let { ctx ->
                startActivity(Intent(ctx, MainActivity::class.java))
            }
        }

        val register: TextView = view.findViewById(R.id.login_register)
        register.setOnClickListener {
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.auth_container, RegisterFragment.newInstance())
                ?.commit()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
