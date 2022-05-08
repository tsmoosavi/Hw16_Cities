package com.example.hw16_cities.recyclerview

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16_cities.*
import com.example.hw16_cities.databinding.HomerecyclerviewBinding

typealias buttonClickHandler = (Button, City) ->Unit
class HomeRecyclerAdapter(var buttonClick: buttonClickHandler) : ListAdapter<City, HomeRecyclerAdapter.ItemHolder>(CityDiffCallback) {

    class ItemHolder(val binding: HomerecyclerviewBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(city: City,buttonClick: buttonClickHandler){
//            binding.cityButton.text = city.name
//            binding.cityButton.setOnClickListener{
//                buttonClick.invoke(binding.cityButton,city)
//            }
//        }
    }
    object CityDiffCallback: DiffUtil.ItemCallback<City>(){

        override fun areItemsTheSame(oldItem:City, newItem: City): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: HomerecyclerviewBinding  = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.homerecyclerview,
            parent,false
        )
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.homerecyclerview, parent, false)

        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
//        holder.bind(getItem(position),buttonClick)
        holder.binding.cityButton.text =getItem(position).name
        buttonClick(holder.binding.cityButton,ListViewModel().x[position])
    }
}