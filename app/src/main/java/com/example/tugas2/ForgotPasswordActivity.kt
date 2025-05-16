package com.example.tugas2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2.databinding.ActivityForgotPasswordBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_forgot_password)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText(this,"Home Click", Toast.LENGTH_SHORT).show()
                    true }
                R.id.navigation_search -> {
                    Toast.makeText(this,"Search Click", Toast.LENGTH_SHORT).show()
                    true }
                R.id.navigation_notification -> {
                    Toast.makeText(this,"Notification Click", Toast.LENGTH_SHORT).show()
                    true }
                else -> false
            }
        }

        binding.btres.setOnClickListener {
            val email : String = binding.editTextText2.toString().trim()
            if (email.isEmpty()) {
                binding.editTextText2.error = "Input Email"
                binding.editTextText2.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextText2.error = "Invalid Email"
                binding.editTextText2.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "cek email untuk reset password", Toast.LENGTH_SHORT).show()
                    Intent(this, LoginActivity::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

        }
        val branda: TextView = findViewById(R.id.branda)

        branda.setOnClickListener {
            val intentHome = Intent(this, MainActivity::class.java)
            startActivity(intentHome)

        }

        val kontak: TextView = findViewById(R.id.kontak)

        kontak.setOnClickListener {
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789"))
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789")))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> {
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
                true
            }

            R.id.setting -> {
                Toast.makeText(this, "Setting Click", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.logout -> {
                Toast.makeText(this, "Logout Click", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
