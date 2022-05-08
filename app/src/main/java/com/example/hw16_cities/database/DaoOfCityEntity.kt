package com.example.hw16_cities.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hw16_cities.City
import com.example.hw16_cities.database.CityEntity

@Dao
interface DaoOfCityEntity {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCity(city: CityEntity)

    @Delete
    fun removeCity(city: CityEntity)

    @Query("Select * From CityEntity")
    fun getList(): LiveData<List<CityEntity>>


}