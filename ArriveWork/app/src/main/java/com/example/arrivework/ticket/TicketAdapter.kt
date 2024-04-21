package com.example.arrivework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.arrivework.databinding.AllTiketBinding

class TicketAdapter():  RecyclerView.Adapter<TicketHolder>() {

    private var data: List<Tickets> = emptyList()

    fun setData(data: List<Tickets>) {
        this.data = data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val binding = AllTiketBinding.inflate(LayoutInflater.from(parent.context))
        return TicketHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val item = data[position]
        with(holder.binding) {
            imageLines.load(item.id)
            airTerminals.text = "${item.departure.airport}"
            time.text = "${item.departure.date}"
            price.text = "${item.price.value}"
            timeWay.text = "${item.arrival.date}"
            airTerminals2.text = "${item.arrival.airport}"
            transfers.text= "Пересадки: ${item.has_transfer}"
        }
    }
}

class TicketHolder( val binding: AllTiketBinding): RecyclerView.ViewHolder(binding.root)