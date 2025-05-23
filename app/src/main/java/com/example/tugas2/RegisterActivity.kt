package com.example.tugas2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas2.databinding.ActivityRegisterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

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


        binding.btreg.setOnClickListener {
            val email : String = binding.editTextText.text.toString().trim()
            val password : String = binding.editTextTextPassword.text.toString().trim()
            val confirmPassword : String = binding.editTextTextPassword2.text.toString().trim()

            if (email.isEmpty()) {
                binding.editTextText.error = "Input Email"
                binding.editTextText.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editTextText.error = "Invalid Email"
                binding.editTextText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.editTextTextPassword.error = "Password harus lebih dari 6 karakter"
                binding.editTextTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.editTextTextPassword2.error = "password harus sama"
                binding.editTextTextPassword2.requestFocus()
                return@setOnClickListener
            }
            registerUser(email, password)
        }
        val punyaakun: TextView = findViewById(R.id.punyaakun)

        binding.punyaakun.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        val kontak: TextView = findViewById(R.id.kontak)

        kontak.setOnClickListener {
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789"))
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789")))
        }
    }

    private fun registerUser(email: String, password: String) {

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isSuccessful) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
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