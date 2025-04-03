package com.example.tugas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleView : AppCompatActivity() {
    private lateinit var kerajaanRecyclerView: RecyclerView
    private lateinit var kerajaanAdapter: MyAdapter
    private lateinit var listKerajaan: ArrayList<ItemData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        kerajaanRecyclerView = findViewById(R.id.kerajaan)
        listKerajaan = ArrayList()

        listKerajaan.add(ItemData(R.drawable.majapahit, "Majapahit", "Jawa Timur"))
        listKerajaan.add(ItemData(R.drawable.kutai, "Kutai", "Kalimantan Timur"))
        listKerajaan.add(ItemData(R.drawable.tarumanegara, "Tarumanegara", "Jawa Barat"))
        listKerajaan.add(ItemData(R.drawable.sriwijaya, "Sriwijaya", "Sumatra Selatan"))
        listKerajaan.add(ItemData(R.drawable.mataram_kuno, "Mataram Kuno", "Yogaykarta"))
        listKerajaan.add(ItemData(R.drawable.kediri, "Kediri", "Jawa Timur"))
        listKerajaan.add(ItemData(R.drawable.singhasari, "Singhasari", "Jawa Timur"))
        listKerajaan.add(ItemData(R.drawable.perlak, "Perlak", "Aceh Timur"))
        listKerajaan.add(ItemData(R.drawable.kalingga, "Kalingga", "Jawa Tengah"))

        kerajaanRecyclerView.layoutManager = LinearLayoutManager(this)
        kerajaanRecyclerView.setHasFixedSize(true)
        kerajaanAdapter = MyAdapter(listKerajaan)
        kerajaanRecyclerView.adapter = kerajaanAdapter

    }
}