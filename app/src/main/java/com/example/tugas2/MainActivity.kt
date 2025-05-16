package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bottomNavigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)
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

        val tugas2dan3 = findViewById<Button>(R.id.button3)
        tugas2dan3.setOnClickListener {
            val intentHome = Intent(this, RegisterActivity::class.java)
            startActivity(intentHome)
        }

        val tugas4 = findViewById<Button>(R.id.button4)
        tugas4.setOnClickListener {
            val intentHome = Intent(this, RecycleView::class.java)
            startActivity(intentHome)
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

            R.id.login -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}