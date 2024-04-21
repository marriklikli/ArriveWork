package com.example.arrivework.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.arrivework.R
import com.example.arrivework.databinding.FragmentSearchBinding
import java.util.ArrayList


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding
        get() = _binding!!
    lateinit var adapter: SearchAdapter
    lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initial()
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.hardButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_plugFragment)
        }
        binding.anywhereButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_plugFragment)
        }
        binding.weekendsButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_plugFragment)
        }
        binding.hotButton.setOnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_plugFragment)
        }

        binding.okay.setOnClickListener{
            findNavController().navigate(R.id.action_searchFragment_to_searchCountryFragment)
        }

    }

    private fun initial() {
        recyclerView = binding.countryList
        adapter = SearchAdapter()
        recyclerView.adapter = adapter
        adapter.setList(myCountry())
    }

    fun myCountry(): ArrayList<Search> {

        val countryList = ArrayList<Search>()

        val country = Search("Стамбул")

        countryList.add(country)

        val country2 = Search("Сочи")

        countryList.add(country)

        val country3 = Search("Пхукет")

        countryList.add(country)


        return countryList
    }
}