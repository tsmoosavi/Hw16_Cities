package com.example.hw16_cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.hw16_cities.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding

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

    }

    private fun cityButtonClick(button: Button, city: City) {
        if (city.isSelected){
            button.setBackgroundResource(R.color.green)
        }
        else if (!city.isSelected){
            button.setBackgroundResource(R.color.orange)
        }
        button.setOnClickListener {
            city.isSelected = !city.isSelected
            if (city.isSelected){
                Toast.makeText(activity, "selected", Toast.LENGTH_SHORT).show()
                button.setBackgroundResource(R.color.green)
            }
            else if (!city.isSelected){
                Toast.makeText(activity, "unselected", Toast.LENGTH_SHORT).show()
                button.setBackgroundResource(R.color.orange)
            }
        }

    }
}