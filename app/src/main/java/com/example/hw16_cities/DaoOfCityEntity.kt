package com.example.hw16_cities

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoOfCityEntity {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCity(city: CityEntity)

    @Delete
    fun removeCity(city:CityEntity)

    @Query("Select * From CityEntity")
    fun getList(): LiveData<List<CityEntity>>


}