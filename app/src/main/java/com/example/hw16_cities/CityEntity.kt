package com.example.hw16_cities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val  cityName : String
        )