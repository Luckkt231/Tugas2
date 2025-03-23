package com.example.tugas2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas2.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val button: Button = findViewById(R.id.btreg)
        button.setOnClickListener {
            Toast.makeText(this, "Berhasil Register", Toast.LENGTH_SHORT).show()
        }
        val punyaakun: TextView = findViewById(R.id.punyaakun)

        punyaakun.setOnClickListener {
            val intentHome = Intent(this, LoginActivity::class.java)
            startActivity(intentHome)
        }

        val kontak: TextView = findViewById(R.id.kontak)

        kontak.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789"))
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:08123456789")))
        }
    }
}