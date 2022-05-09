package com.example.hw16_cities.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16_cities.R
import com.example.hw16_cities.database.CityEntity
import com.example.hw16_cities.databinding.SelectedcityrecyclerviewBinding

typealias buttonClick = (TextView, CityEntity) ->Unit
class SelectedCityRecyclerAdapter(var buttonClickHandler: buttonClick) : ListAdapter<CityEntity, SelectedCityRecyclerAdapter.ItemHolder>(CityDiffCallback) {

    class ItemHolder(val binding: SelectedcityrecyclerviewBinding): RecyclerView.ViewHolder(binding.root){

    }
    object CityDiffCallback: DiffUtil.ItemCallback<CityEntity>(){

        override fun areItemsTheSame(oldItem: CityEntity, newItem: CityEntity): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: CityEntity, newItem: CityEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding: SelectedcityrecyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.selectedcityrecyclerview,
            parent,false
        )
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.selectedcityrecyclerview, parent, false)

        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.binding.cityTv.text = getItem(position).cityName
        buttonClickHandler(holder.binding.cityTv,getItem(position))
    }

}