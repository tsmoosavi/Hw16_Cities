package com.example.hw16_cities.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface  DaoOfSelectedCity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCity(city: SelectedCityEntity)

    @Query("Delete from SelectedCityEntity Where cityName = :city")
    fun deleteItem (city:String)

    @Query("Select * From SelectedCityEntity")
    fun getList(): LiveData<List<SelectedCityEntity>>
}