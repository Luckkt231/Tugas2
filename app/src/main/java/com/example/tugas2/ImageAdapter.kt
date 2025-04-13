package com.example.tugas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter (private val deskripsiList: ArrayList<Image>) :
RecyclerView.Adapter<ImageAdapter.ImageViewHolder> (){

    var onItemClick : ((Image) -> Unit)? = null

    class ImageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id._image)
        val imageTitle: TextView = itemView.findViewById(R.id._imagetitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return deskripsiList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val deskripsi = deskripsiList[position]
        holder.imageView.setImageResource(deskripsi.imageSource)
        holder.imageTitle.text = deskripsi.imageTitle

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(deskripsi)
        }
    }

}
