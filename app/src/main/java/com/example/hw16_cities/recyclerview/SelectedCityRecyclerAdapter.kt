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
import com.example.hw16_cities.database.SelectedCityEntity
import com.example.hw16_cities.databinding.SelectedcityrecyclerviewBinding

//typealias buttonClick = (TextView, SelectedCityEntity) ->Unit
class SelectedCityRecyclerAdapter : ListAdapter<SelectedCityEntity, SelectedCityRecyclerAdapter.ItemHolder>(CityDiffCallback) {
//(var buttonClickHandler: buttonClick)
    class ItemHolder(val binding: SelectedcityrecyclerviewBinding): RecyclerView.ViewHolder(binding.root){

    }
    object CityDiffCallback: DiffUtil.ItemCallback<SelectedCityEntity>(){

        override fun areItemsTheSame(oldItem: SelectedCityEntity, newItem: SelectedCityEntity): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: SelectedCityEntity, newItem: SelectedCityEntity): Boolean {
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
//        buttonClickHandler(holder.binding.cityTv,getItem(position))
    }

}