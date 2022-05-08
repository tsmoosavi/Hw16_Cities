package com.example.hw16_cities.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hw16_cities.City
import com.example.hw16_cities.HomeViewModel
import com.example.hw16_cities.R
import com.example.hw16_cities.database.CityEntity
import com.example.hw16_cities.databinding.FragmentHomeBinding
import com.example.hw16_cities.recyclerview.HomeRecyclerAdapter

var selectedCityList = arrayListOf<String>()
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    val vm: HomeViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = HomeRecyclerAdapter{button, city ->cityButtonClick(button,city)  }
        binding.homeRV.adapter = adapter
        adapter.submitList(vm.listOfCity)
        binding.showSelectedCitiesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_selectedCitiesFragment)
        }

    }

    private fun cityButtonClick(button: Button, city: City) {
            for(theCity in selectedCityList){
                if (selectedCityList.contains(button.text)){
                    button.text= "hi${city.name}"
                    button.setBackgroundColor(resources.getColor(R.color.green))
                }else{
                    button.text= "good${city.name}"
                    button.setBackgroundColor(resources.getColor(R.color.orange))
                }
            }





//        if (city.isSelected){
//            button.text= "hi"
//            button.setBackgroundResource(R.color.green)
//        }
//        else if (!city.isSelected){
//
//            button.setBackgroundResource(R.color.orange)
//        }
        button.setOnClickListener {
            city.isSelected = !city.isSelected
            if (city.isSelected){
                Toast.makeText(activity, "selected", Toast.LENGTH_SHORT).show()
                selectedCityList.add(city.name)
//                button.text= "hi"
                vm.selectCity(CityEntity(0,city.name))
                button.setBackgroundColor(resources.getColor(R.color.green))
            }
            else if (!city.isSelected){
                Toast.makeText(activity, "unselected", Toast.LENGTH_SHORT).show()
                selectedCityList.remove(city.name)
//                button.text= "goodbye"
                button.setBackgroundColor(resources.getColor(R.color.orange))
            }
        }

    }
}