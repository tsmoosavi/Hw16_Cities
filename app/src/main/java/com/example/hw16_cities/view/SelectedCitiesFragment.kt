package com.example.hw16_cities.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.hw16_cities.HomeViewModel
import com.example.hw16_cities.database.CityEntity
import com.example.hw16_cities.databinding.FragmentSelectedCitiesBinding
import com.example.hw16_cities.recyclerview.SelectedCityRecyclerAdapter


class SelectedCitiesFragment : Fragment() {
    lateinit var binding: FragmentSelectedCitiesBinding
    val vm: HomeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedCitiesBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = SelectedCityRecyclerAdapter{textView, city -> textViewClick(textView,city)}
        binding.selectedRecyclerView.adapter = adapter

        vm.selectedCitiesListLD.observe(viewLifecycleOwner){
            if (it != null){
                var adapter = SelectedCityRecyclerAdapter{textView, city -> textViewClick(textView,city)}
                binding.selectedRecyclerView.adapter = adapter
                adapter.submitList(it)
            }
        }
    }

    private fun textViewClick(textView:TextView,city:CityEntity ) {
       textView.setOnClickListener {
           city.isSelected = !city.isSelected
           vm.update(city)
       }
    }
}