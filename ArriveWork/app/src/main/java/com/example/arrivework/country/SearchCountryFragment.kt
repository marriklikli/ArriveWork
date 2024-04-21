package com.example.arrivework.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.arrivework.CountryAdapter
import com.example.arrivework.R
import com.example.arrivework.databinding.FragmentSearchCountryBinding

import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.text.SimpleDateFormat
import java.util.*


class SearchCountryFragment : Fragment() {
    private val viewModel: CountryViewModel by activityViewModels{ CountryViewModelRepository() }
    private var _binding: FragmentSearchCountryBinding? = null
    private val binding
        get() = _binding!!
    val countryAdapter = CountryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd-MM-yy")
        _binding = FragmentSearchCountryBinding.inflate(inflater, container, false)
        binding.backButton.setOnClickListener{
            val dateDialod = MaterialDatePicker.Builder.datePicker()
                .build()
            dateDialod.addOnPositiveButtonClickListener { timeInMillis ->
                calendar.timeInMillis = timeInMillis
                Snackbar.make(binding.data, dateFormat.format(calendar.time), Snackbar.LENGTH_SHORT)
            }
            dateDialod.show(parentFragmentManager, "DatePicker")
        }
        binding.data.setOnClickListener{
            val dateDialod = MaterialDatePicker.Builder.datePicker()
                .build()
            dateDialod.addOnPositiveButtonClickListener { timeInMillis ->
                calendar.timeInMillis = timeInMillis
                Snackbar.make(binding.data, dateFormat.format(calendar.time), Snackbar.LENGTH_SHORT)
            }
            dateDialod.show(parentFragmentManager, "DatePicker")
        }

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onGetData()
        binding.countryList.adapter = countryAdapter
        viewModel.data.onEach {
            countryAdapter.setData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.allTiketButton.setOnClickListener{
            findNavController().navigate(R.id.action_searchCountryFragment_to_allTiketFragment)
        }
    }
}