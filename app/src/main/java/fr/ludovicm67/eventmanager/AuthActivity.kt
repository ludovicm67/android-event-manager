package fr.ludovicm67.eventmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.ludovicm67.eventmanager.ui.register.RegisterFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.auth_container, RegisterFragment.newInstance())
                .commitNow()
        }
    }

}
