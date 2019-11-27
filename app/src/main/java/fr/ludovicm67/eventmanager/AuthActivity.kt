package fr.ludovicm67.eventmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.core.content.ContextCompat
import fr.ludovicm67.eventmanager.data.AppDatabase
import fr.ludovicm67.eventmanager.ui.login.LoginFragment
import androidx.lifecycle.observe

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        val w: Window = window
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        w.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.auth_container, LoginFragment.newInstance())
                .commitNow()
        }

        val db = AppDatabase(this)
        val users = db.userDao().getAll()
        users.observe(this) { list ->
            println("nb users: " + list.size)
            list.forEach {
                println(it)
            }
        }

        val currentUser = db.currentUserDao().getAll()
        currentUser.observe(this) { list ->
            if (list.isNotEmpty()) {
                println("User is authenticated")
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                println("User is not logged in")
            }
        }
    }
}
