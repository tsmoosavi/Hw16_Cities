package com.example.hw16_cities.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16_cities.ViewModel.HomeViewModel
import com.example.hw16_cities.recyclerview.SwipeToDeleteCallback
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
        var adapter = SelectedCityRecyclerAdapter()
        binding.selectedRecyclerView.adapter = adapter
        var orin = resources.configuration.orientation
        if(orin == Configuration.ORIENTATION_LANDSCAPE){
            binding.selectedRecyclerView.layoutManager = GridLayoutManager(context,2)
        }else{
            binding.selectedRecyclerView.layoutManager = LinearLayoutManager(context)
        }

        vm.selectedCitiesListLD.observe(viewLifecycleOwner){
            if (it != null){
                adapter.submitList(it)
                val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        val pos = viewHolder.adapterPosition
                        var city = vm.getCity(it[pos].cityName)
                        city.isSelected = !city.isSelected
                        vm.update(city)
                        vm.delete(it[pos].cityName)
                        adapter.submitList(it)
                    }
                }

                val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
                itemTouchHelper.attachToRecyclerView(binding.selectedRecyclerView)

            }
        }
    }

}