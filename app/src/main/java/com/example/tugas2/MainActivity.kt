package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

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

        val tugas5 = findViewById<Button>(R.id.button5)
        tugas5.setOnClickListener {
            val intentHome = Intent(this, MainActivity2::class.java)
            startActivity(intentHome)

        }
    }
}