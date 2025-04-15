package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val kerajaanList: ArrayList<Image>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder> (){

        var onItemClick : ((Image) -> Unit)? = null

        class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
            val imageView : ImageView = itemView.findViewById(R.id.imagekrj)
            val imageNama : TextView = itemView.findViewById(R.id.namakrj)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kerajaanList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val deskripsi = kerajaanList[position]
        holder.imageView.setImageResource(deskripsi.imageSource)
        holder.imageNama.text = deskripsi.imageTitle


        holder.itemView.setOnClickListener {
            onItemClick?.invoke(deskripsi)
        }
    }
}