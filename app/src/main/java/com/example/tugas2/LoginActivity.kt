package com.example.tugas2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.btlog)
        button.setOnClickListener {
            Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
        }
        val forgotpass: TextView = findViewById(R.id.forgotpass)
        val branda: TextView = findViewById(R.id.branda)

        forgotpass.setOnClickListener {
            val intentHome = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentHome)

        }
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
}