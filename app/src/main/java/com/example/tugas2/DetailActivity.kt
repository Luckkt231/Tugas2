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

        val deskripsi = intent.getParcelableExtra<Image>("deskripsi")
        if (deskripsi != null) {
            val imageView: ImageView = findViewById(R.id._imageSource)
            val imageTitle: TextView = findViewById(R.id._imageTitle)
            val imageDesc: TextView = findViewById(R.id._imageDesc)

            imageView.setImageResource(deskripsi.imageSource)
            imageTitle.text = deskripsi.imageTitle
            imageDesc.text = deskripsi.imageDesc
        }
    }
}