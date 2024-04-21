package com.example.arrivework.ticket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.arrivework.R
import com.example.arrivework.TicketAdapter
import com.example.arrivework.databinding.FragmentAllTiketBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AllTiketFragment : Fragment() {
    private val viewModel: TicketViewModel by activityViewModels{ TicketViewModelRepository() }
    private var _binding: FragmentAllTiketBinding? = null
    private val binding
        get() = _binding!!
    val ticketAdapter = TicketAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllTiketBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onGetData()
        binding.tiketList.adapter = ticketAdapter
        viewModel.data.onEach {
            ticketAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.backButton2.setOnClickListener{
            findNavController().navigate(R.id.action_allTiketFragment_to_searchCountryFragment)
        }
        binding.chartButton.setOnClickListener{
            findNavController().navigate(R.id.action_allTiketFragment_to_plugFragment)
        }
        binding.filterButton.setOnClickListener{
            findNavController().navigate(R.id.action_allTiketFragment_to_plugFragment)
        }
    }

}