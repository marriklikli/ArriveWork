package com.example.arrivework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.arrivework.databinding.MusicListBinding

class MusicAdapter():  RecyclerView.Adapter<MusicHolder>() {

    private var data: List<offers> = emptyList()

    fun setData(data: List<offers>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val binding = MusicListBinding.inflate(LayoutInflater.from(parent.context))
        return MusicHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        val item = data[position]
        with(holder.binding) {
            imageMusic.load(item.id)
            name.text = "${item.title}"
            countri.text = "${item.town}"
            price.text = "${item.price.value}"
        }
    }
}

class MusicHolder( val binding: MusicListBinding): RecyclerView.ViewHolder(binding.root)