package com.example.arrivework.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arrivework.R.layout.country_list
import kotlinx.android.synthetic.main.country_list.view.*

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchViewHolder> (){

    private var countryList = emptyList<Search>()

    class SearchViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(country_list, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.itemView.name_country.text = countryList[position].nameCountry

    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Search>){
        countryList = list
        notifyDataSetChanged()
    }
}