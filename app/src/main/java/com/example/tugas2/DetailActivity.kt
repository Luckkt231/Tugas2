package com.example.tugas2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val kerajaan = intent.getParcelableExtra<Image>("kerajaan")
        if (kerajaan != null) {
            val imageView: ImageView = findViewById(R.id._imageSource)
            val imageTitle: TextView = findViewById(R.id._imageTitle)
            val imageDesc: TextView = findViewById(R.id._imageDesc)

            imageView.setImageResource(kerajaan.imageSource)
            imageTitle.text = kerajaan.imageTitle
            imageDesc.text = kerajaan.imageDesc
        }
    }
}