package com.example.arrivework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.arrivework.databinding.RecomendListBinding

class CountryAdapter ():  RecyclerView.Adapter<CountryHolder>() {

    private var data: List<ticketsoffers> = emptyList()

    fun setData(data: List<ticketsoffers>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val binding = RecomendListBinding.inflate(LayoutInflater.from(parent.context))
        return CountryHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        val item = data[position]
        with(holder.binding) {
            imageLines.load(item.id)
            nameLines.text = "${item.title}"
            time.text = "${item.time_range}"
            price.text = "${item.price.value}"
        }
    }
}

class CountryHolder( val binding: RecomendListBinding): RecyclerView.ViewHolder(binding.root)