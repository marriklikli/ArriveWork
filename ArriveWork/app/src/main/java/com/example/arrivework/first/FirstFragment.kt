package com.example.arrivework.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.arrivework.MusicAdapter
import com.example.arrivework.R
import com.example.arrivework.databinding.FragmentFirstBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class FirstFragment : Fragment() {
    private val viewModel: MainViewMadol by activityViewModels{ MainViewModelRepository() }
    private var _binding: FragmentFirstBinding? = null
    private val binding
        get() = _binding!!
    val musicAdapter = MusicAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.hotel_button -> findNavController().navigate(R.id.action_firstFragment_to_plugFragment)
                R.id.short_button -> findNavController().navigate(R.id.action_firstFragment_to_plugFragment)
                R.id.subscriptions_button -> findNavController().navigate(R.id.action_firstFragment_to_plugFragment)
                R.id.profile_button -> findNavController().navigate(R.id.action_firstFragment_to_plugFragment)
            }
            true
        }

        binding.whereFrom.setOnClickListener {
            binding.whereFromText1.text = binding.whereFromText.toString()
        }
        binding.where.setOnClickListener {
            binding.wheretext.text = binding.whereText.toString()
        }

        viewModel.onGetData()
        binding.musicList.adapter = musicAdapter
        viewModel.data.onEach {
            musicAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.search.setOnClickListener{
            findNavController().navigate(R.id.action_firstFragment_to_searchFragment)
        }

    }



}