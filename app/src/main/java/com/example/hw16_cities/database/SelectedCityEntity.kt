package com.example.hw16_cities.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SelectedCityEntity(
    @PrimaryKey(autoGenerate = true) val id : Int,
    val  cityName : String,
    var isSelected:Boolean
)


